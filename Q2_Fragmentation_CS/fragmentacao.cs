using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fragmentacao
{
    using System;
    using System.Collections.Generic;
    using System.Diagnostics;
    using System.Linq;
    using System.Runtime.InteropServices;
    using System.Security.Cryptography;
    using System.Text;
    using System.Threading.Tasks;

        internal class Program
        {
            static void Main(string[] args)
            {
                // Cria a memória com partições fixas
                Memoria memoria = new Memoria(new int[] { 100, 150, 200, 250, 300 });

                // Cria os processos
                Particao P1 = new Particao(90, "P1", false);
                Particao P2 = new Particao(140, "P2", false);
                Particao P3 = new Particao(180, "P3", false);
                Particao P4 = new Particao(100, "P4", false);
                Particao P5 = new Particao(350, "P5", false);

                // Executa a sequência de testes
                memoria.AlocarProcesso(P1);
                memoria.AlocarProcesso(P2);
                memoria.AlocarProcesso(P3);
                memoria.liberarProcesso("P2");
                memoria.AlocarProcesso(P4);
                memoria.AlocarProcesso(P5);

                // Exibe o estado final da memória
                memoria.exibir_memoria();
            }
        }


        public class Memoria
        {
            //Realiza a criação de uma lista de partições
            private List<Bloco> blocos = new List<Bloco>();


            public Memoria(int[] tamanhos)
            {
                for (int i = 0; i < tamanhos.Length; i++)
                {
                    blocos.Add(new Bloco("A" + (i + 1), tamanhos[i]));
                }
            }

            public void liberarProcesso(String NomePart)
            {
                foreach (var bloco in blocos)
                {
                    if (!bloco.Livre && bloco.Processo.nome == NomePart)
                    {
                        bloco.Livre = true;
                        bloco.Processo = null;
                        bloco.Fragmentacao = 0;
                        Console.WriteLine($"Processo{NomePart} liberado de {bloco.Nome}");
                        return;
                    }
                }

            }

            public void AlocarProcesso(Particao part)
            {
                foreach (var bloco in blocos)
                {
                    if (bloco.Livre && bloco.Tamanho >= part.tamanho)
                    {
                        bloco.Livre = false;
                        bloco.Processo = part;
                        bloco.Fragmentacao = bloco.Tamanho - part.tamanho;

                        Console.WriteLine($"{part.nome} alocado em {bloco.Nome} (tamanho {bloco.Tamanho}). " +
                                          $"Fragmentação interna: {bloco.Fragmentacao} unidades.");
                        return;
                    }
                }

                Console.WriteLine($"Não há partição livre suficiente para {part.nome} ({part.tamanho} unidades).");
            }

            public void exibir_memoria()
            {
                Console.WriteLine("\n=== ESTADO ATUAL DA MEMÓRIA ===");
                int totalFragmentacao = 0;

                foreach (var bloco in blocos)
                {
                    if (bloco.Livre)
                    {
                        Console.WriteLine($"{bloco.Nome} ({bloco.Tamanho} unidades): LIVRE");
                    }
                    else
                    {
                        Console.WriteLine($"{bloco.Nome} ({bloco.Tamanho} unidades): " +
                                          $"{bloco.Processo.nome} ({bloco.Processo.tamanho}) — sobra {bloco.Fragmentacao}");
                        totalFragmentacao += bloco.Fragmentacao;
                    }
                }

                Console.WriteLine($"\n Fragmentação interna total: {totalFragmentacao} unidades.\n");
            }
        }

    }






    public class Particao
    {
        public int tamanho { get; private set; }
        public string nome { get; private set; }
        public bool esta_livre { get; set; }

        public Particao(int tamanho, string nome, bool esta_livre)
        {
            this.tamanho = tamanho;
            this.nome = nome;
            this.esta_livre = esta_livre;
        }
    }

    // Representa um bloco fixo de memória
    public class Bloco
    {
        public string Nome { get; set; }
        public int Tamanho { get; set; }
        public bool Livre { get; set; } = true;
        public Particao Processo { get; set; }
        public int Fragmentacao { get; set; }

        public Bloco(string nome, int tamanho)
        {
            Nome = nome;
            Tamanho = tamanho;
        }
    }
