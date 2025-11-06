# Memory Management in Operating Systems

This repository contains the practical implementations and theoretical analyses for the "Memory Management in Operating Systems" project. This work was developed for the Operating Systems discipline in the Software Engineering program.

-   **Course:** Software Engineering
-   **Discipline:** Operating Systems
-   **Professor:** José Carlos Domingues Flores

## 🚀 Project Overview

This project explores fundamental concepts of memory management in operating systems. It combines theoretical explanations with practical code implementations in C, C#, Python, and Java to demonstrate core mechanisms.

### Implemented Concepts

The repository covers the following topics:

1.  **Q1: Static vs. Dynamic Allocation:**
    * A theoretical comparison of static and dynamic memory.
    * A **C** program that demonstrates allocating arrays on both the stack (static) and the heap (dynamic) and comparing their memory addresses.

2.  **Q2: Memory Fragmentation Simulation:**
    * A theoretical explanation of internal and external fragmentation.
    * A **C#** program that simulates a fixed-partition memory manager using the **First-Fit** algorithm, calculating and reporting internal fragmentation.

3.  **Q3: FIFO Page Replacement Algorithm:**
    * A theoretical overview of the First-In, First-Out (FIFO) algorithm.
    * A **Java** program that simulates FIFO, processes a sequence of page references, and calculates the total page faults and hit/fault rate.

4.  **Q4: Python Garbage Collection:**
    * An explanation of Python's GC mechanism, including reference counting and the generational collector.
    * A **Python** program demonstrating automatic destruction, reference cycles, and the use of the `gc` module to force collection.

5.  **Q5: Allocation Performance Comparison:**
    * A theoretical analysis of stack vs. heap performance.
    * A program that measures and compares the time taken to allocate and deallocate millions of variables on the stack versus the heap.

---

## 📁 Repository Structure

The project is organized into folders, one for each question. The theoretical answers and screenshots are consolidated in the `Report.pdf` document.

```

.
├── 📄 README.md
├── 📄 Report.pdf
│
├── 📁 Q1\_Static\_Dynamic\_C/
│   └── 📄 dinamicaXestatica.c
│
├── 📁 Q2\_Fragmentation\_CS/
│   └── 📄 fragmentacao.cs
│
├── 📁 Q3\_FIFO\_Java/
│   └── 📄 programaFIFO.java
│
├── 📁 Q4\_Garbage\_Collection\_Python/
│   └── 📄 ColetorLixo.py
│
├── 📁 Q5\_Performance\_Comparison/
│   └── 📄 comparacao.py   (or .c, .java)


````

---

## ⚙️ How to Compile and Run

This guide provides the full step-by-step instructions to clone, compile, and run all practical assignments in this repository using a `bash` terminal.

### Prerequisites

Before you begin, ensure you have the following tools installed on your system:
* **Git** (for cloning the repository)
* **GCC** (for compiling the C program, Q1)
* **.NET SDK** (for running the C# project, Q2)
* **Java JDK** (for compiling and running the Java program, Q3 )
* **Python 3** (for running the Python scripts, Q4 & Q5)

### Step 1: Clone the Repository

First, clone this repository to your local machine.

```bash
# Clone the repository (replace with your repo's URL)
git clone https://github.com/GuinaF2/Gerenciamento-de-Memoria---SO

# Navigate into the newly created directory
cd Grenciamento-de-Memoria---SO
````

### Step 2: Run the Assignments

Follow the instructions for each question below.

#### Q1: Static vs. Dynamic (C)

```bash
# Navigate to the correct folder
cd Q1_Static_Dynamic_C/

# Compile the C program
gcc main.c -o main

# Run the executable
./main
```

#### Q2: Memory Fragmentation (C\#)

```bash
# Navigate back to the root (or use 'cd ../') and enter the Q2 folder
cd ../Q2_Fragmentation_CS/

# Run the C# project (dotnet will handle compilation)
dotnet run
```

#### Q3: FIFO Algorithm (Java)

```bash
# Navigate back to the root and enter the Q3 folder
cd ../Q3_FIFO_Java/

# Compile the Java file
javac FIFO.java

# Run the compiled .class file
java FIFO
```

#### Q4: Garbage Collection (Python)

```bash
# Navigate back to the root and enter the Q4 folder
cd ../Q4_Garbage_Collection_Python/

# Run the Python script
python3 main.py
```

#### Q5: Performance Comparison (Python/Java/C)

```bash
# Navigate back to the root and enter the Q5 folder
cd ../Q5_Performance_Comparison/

# Run the Python script
python3 main.py
```

-----

## 👥 Authors

This project was developed by:

  * Guilherme Henrique Oliveira da Silva
  * Livia dos Reis Gomides
  * Miguel Mendes
  * Vinicius de Souza Fernandes

-----

## 📜 License

This project is licensed under the MIT License. See the `LICENSE` file for details.

```
```
