# Memory Management in Operating Systems

This repository contains the practical implementations and theoretical analyses for the "Memory Management in Operating Systems" project. This work was developed for the Operating Systems discipline in the Software Engineering program.

-   **Course:** Software Engineering
-   **Discipline:** Operating Systems
-   **Professor:** José Carlos Domingues Flores

## 🚀 Project Overview

This project explores fundamental concepts of memory management in operating systems. It combines theoretical explanations with practical code implementations in C, Python, and Java to demonstrate core mechanisms.

### Implemented Concepts

The repository covers the following topics:

1.  **Q1: Static vs. Dynamic Allocation:**
    * A theoretical comparison of static and dynamic memory.
    * A **C** program that demonstrates allocating arrays on both the stack (static) and the heap (dynamic) and comparing their memory addresses.

2.  **Q2: Memory Fragmentation Simulation:**
    * A theoretical explanation of internal and external fragmentation.
    * A **Python** program that simulates a fixed-partition memory manager using the **First-Fit** algorithm, calculating and reporting internal fragmentation.

3.  **Q3: FIFO Page Replacement Algorithm:**
    * A theoretical overview of the First-In, First-Out (FIFO) algorithm.
    * A **Java** program that simulates FIFO, processes a sequence of page references, and calculates the total page faults and hit/fault rate.

4.  **Q4: Python Garbage Collection:**
    * An explanation of Python's GC mechanism, including reference counting and the generational collector.
    * A **Python** program demonstrating automatic destruction, reference cycles, and the use of the `gc` module to force collection.

5.  **Q5: Allocation Performance Comparison:**
    * A theoretical analysis of stack vs. heap performance.
    * A program that measures and compares the time taken to allocate and deallocate millions of variables on the stack versus the heap.

6.  **Bonus: LRU Page Replacement Algorithm:**
    * An implementation of the **Least Recently Used (LRU)** page replacement algorithm.
    * A comparative analysis against the FIFO implementation from Q3, focusing on page fault rates.

---

## 📁 Repository Structure

The project is organized into folders, one for each question. The theoretical answers and screenshots are consolidated in the `Report.pdf` document.

```

.
├── 📄 README.md
├── 📄 Report.pdf
│
├── 📁 Q1\_Static\_Dynamic\_C/
│   └── 📄 main.c
│
├── 📁 Q2\_Fragmentation\_Python/
│   └── 📄 main.py
│
├── 📁 Q3\_FIFO\_Java/
│   └── 📄 FIFO.java
│
├── 📁 Q4\_Garbage\_Collection\_Python/
│   └── 📄 main.py
│
├── 📁 Q5\_Performance\_Comparison/
│   └── 📄 main.py   (or .c, .java)
│
└── 📁 Q\_Bonus\_LRU/
└── 📄 LRU.java  (or .c, .py)

````

---

## ⚙️ How to Compile and Run

Instructions for executing the practical assignments are provided below.

### 1. C Programs (Q1, Q5*)

To compile and run the C programs, navigate to the appropriate directory:

```bash
# Navigate to the directory
cd Q1_Static_Dynamic_C/

# Compile the program
gcc main.c -o main

# Run the executable
./main
````

*(Applies to Q5 if C was used)*

### 2\. Python Programs (Q2, Q4, Q5\*)

To run the Python scripts, you need Python 3.x installed.

```bash
# Navigate to the directory
cd Q2_Fragmentation_Python/

# Run the script
python3 main.py
```

*(Applies to Q4 and Q5 if Python was used)*

### 3\. Java Programs (Q3, Bonus, Q5\*)

To compile and run the Java programs, you need the JDK installed.

```bash
# Navigate to the directory
cd Q3_FIFO_Java/

# Compile the .java file
javac FIFO.java

# Run the compiled .class file
java FIFO
```

*(Applies to the Bonus question and Q5 if Java was used)*

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
