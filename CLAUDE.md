# CLAUDE.md

This file provides guidance for AI assistants working with this repository.

## Project Overview

Algorithm practice repository containing Java and C++ implementations of classical algorithms and data structures. Author: Alexey Merezhin.

## Repository Structure

```
src/
  main/java/           # Java algorithm implementations (one package per problem)
  test/java/           # JUnit 5 tests (mirrors main/ structure)
  jmh/java/            # JMH performance benchmarks
cpp/
  PRIME1/              # Prime number generator (C++/GTest)
  listsort/            # Linked list merge sort (C++/GTest)
  client-server/       # TCP client/server (C++/Make)
  googletest/          # Google Test submodule
```

### Algorithm categories (Java)

- `sorting/classic/` - QuickSort, MergeSort, HeapSort, SelectionSort
- `dynamic_programming/` - ZigZag, palindrome formation
- `graphs/` - BFS, network connectivity
- `interval_scheduling/` - Weighted and unweighted variants
- `strings/` - Palindromic substrings, pattern matching
- `tree/` - Serialization/deserialization
- `heap/` - Min-heap implementation
- `lru/` - LRU cache with O(1) operations
- `longest_inc_subseq/` - O(N*logN) and O(N^2) solutions
- `numbers/` - Prime generation, max sum

## Build & Test Commands

### Java (Gradle)

```bash
# Run all tests
gradle test

# Run JMH performance benchmarks (output in result.txt)
gradle clean jmh
```

- Java 1.8 source compatibility
- JUnit Jupiter 5.2.0 with AssertJ 3.10.0
- JMH 0.4.6 for benchmarks

### C++ (Make)

```bash
# Build and test a C++ project (from its directory)
cd cpp/PRIME1 && make clean && make && ./prime test
cd cpp/listsort && make clean && make
```

- C++14 with clang++
- Google Test/Google Mock (submodule at `cpp/googletest/`)

## Code Conventions

### Java

- One package per algorithm problem (e.g., `lru/`, `heap/`, `longest_inc_subseq/`)
- Package names use `snake_case`
- Test classes follow `*Test.java` naming, placed in `src/test/java/` mirroring the main source tree
- Tests use JUnit 5 (`@Test`, `org.junit.jupiter.api.Assertions`) and AssertJ
- Test classes are package-private (no `public` modifier)
- Complexity annotations in comments (e.g., `// O(N*logN)`)
- Some classes have embedded tests alongside main code (e.g., `Heap.java`)

### C++

- Single `main.cc` per project with implementation + GTest tests combined
- Each project has its own `Makefile`
- `typedef` for container abstraction

### Git commit style

- Lowercase imperative: "add X", "implement X", "upd X", "migrate to X"
- Short, descriptive messages focused on what was added or changed
- No issue numbers or conventional commit prefixes

## Key Files

| File | Purpose |
|------|---------|
| `build.gradle` | Gradle build config (Java deps, JMH, JUnit) |
| `java_collection.md` | Java Collections API cheat sheet |
| `.gitmodules` | Google Test submodule reference |

## Notes

- No CI/CD pipeline configured; builds are local only
- The Gradle wrapper (`gradlew`) is present but the `gradle/` directory is gitignored
- `result.txt` (JMH output) is gitignored
