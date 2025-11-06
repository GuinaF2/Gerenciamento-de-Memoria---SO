import gc
import sys

# Classe Objeto para simular uso de memória.
# __del__ avisa quando o objeto é destruído.
class Objeto:
    def __init__(self, nome):
        self.nome = nome
        self.dados = [0] * 100000  
        self.ref = None
        print(f"Objeto {self.nome} criado.")

    def __del__(self):
        print(f"Objeto {self.nome} destruído (memória liberada).")

# --- Cenário 1: Contagem de Referências (Destruição Imediata) ---
print("\n=== CENÁRIO 1: DESTRUIÇÃO AUTOMÁTICA POR CONTAGEM DE REFERÊNCIAS ===")
obj1 = Objeto("A")

# sys.getrefcount(obj): Retorna o número de referências ativas para o objeto.
print(f"Referências ativas de obj1: {sys.getrefcount(obj1)}")
del obj1  # A contagem zera, __del__ é chamado imediatamente.

# --- Cenário 2: Referências Circulares (O Problema) ---
# O ciclo (B <-> C) impede a contagem de zerar.
# Os objetos NÃO são destruídos pelo 'del' (vazamento de memória).
print("\n=== CENÁRIO 2: REFERÊNCIAS CIRCULARES ===")
obj2 = Objeto("B")
obj3 = Objeto("C")
obj2.ref = obj3
obj3.ref = obj2
del obj2
del obj3
print("Objetos B e C não destruídos imediatamente (referência circular impede GC automático).")


# --- Coleta Forçada (A Solução) ---
print("\nForçando coleta de lixo...")

# gc.collect(): Força o coletor geracional (inteligente) a rodar.
# Ele é capaz de encontrar e destruir ciclos inacessíveis.
gc.collect()  

# --- Cenário 3: Coleta em Massa e Estatísticas ---
print("\n=== CENÁRIO 3: COLETOR GERACIONAL ===")
objetos = [Objeto(f"Temp_{i}") for i in range(5)]
print(f"Referências do primeiro objeto: {sys.getrefcount(objetos[0])}")
objetos.clear() # O 'clear' zera a contagem e já destrói os objetos 'Temp'
coletados = gc.collect()
print(f"GC coletou {coletados} objetos órfãos.")

print("\nEstatísticas do coletor geracional:")

# gc.get_stats(): Retorna o relatório de quantas coletas/objetos
# foram limpos em cada uma das 3 "gerações" de objetos.
for i, stats in enumerate(gc.get_stats()):
    print(f"Geração {i}: {stats}")

print("\nDemonstração concluída.")
