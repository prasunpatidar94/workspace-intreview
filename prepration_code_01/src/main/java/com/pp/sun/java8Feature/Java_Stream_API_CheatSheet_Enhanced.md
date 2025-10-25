
# 🧠 Java Stream API – Complete Cheatsheet

## 📌 1. What is Stream API?
A **Stream** is a **sequence of elements** supporting **functional-style operations** (map, filter, reduce, etc.) on **collections or arrays**.

It helps in **processing data declaratively** (like SQL) rather than imperatively (loops).

---

## 📦 2. Creating Streams

| Source | Example |
|--------|----------|
| From Collection | `list.stream()` |
| From Arrays | `Arrays.stream(arr)` |
| Using Stream.of() | `Stream.of(1,2,3,4)` |
| Infinite Stream | `Stream.iterate(1, n -> n + 1)` |
| Empty Stream | `Stream.empty()` |

```java
List<String> names = List.of("Alice", "Bob", "Charlie");
Stream<String> stream = names.stream();
```

---

## ⚙️ 3. Stream Pipeline

```
Source → Intermediate Operations → Terminal Operation
```

Example:
```java
List<String> result = names.stream()
    .filter(n -> n.startsWith("A"))
    .map(String::toUpperCase)
    .sorted()
    .toList();
```

---

## 🔄 4. Intermediate Operations

| Operation | Description | Example |
|------------|--------------|----------|
| `filter()` | Select elements by condition | `filter(x -> x > 10)` |
| `map()` | Transform each element | `map(x -> x * 2)` |
| `flatMap()` | Flatten nested structures | `flatMap(List::stream)` |
| `distinct()` | Remove duplicates | `distinct()` |
| `sorted()` | Sort elements | `sorted()` or `sorted(Comparator.comparing(...))` |
| `limit(n)` | Take first `n` elements | `limit(5)` |
| `skip(n)` | Skip first `n` elements | `skip(2)` |
| `peek()` | Debug or inspect stream | `peek(System.out::println)` |

---

## 🏁 5. Terminal Operations

| Operation | Description | Example |
|------------|--------------|----------|
| `forEach()` | Iterate and perform action | `forEach(System.out::println)` |
| `collect()` | Convert stream to list/set/map | `collect(Collectors.toList())` |
| `toList()` | New way (Java 16+) | `.toList()` |
| `count()` | Count elements | `count()` |
| `reduce()` | Combine elements to a single result | `reduce(0, Integer::sum)` |
| `findFirst()` | Get first element | `findFirst().get()` |
| `findAny()` | Get any element | `findAny().get()` |
| `anyMatch()` | True if any matches | `anyMatch(x -> x > 10)` |
| `allMatch()` | True if all match | `allMatch(x -> x > 0)` |
| `noneMatch()` | True if none match | `noneMatch(x -> x < 0)` |
| `min()` / `max()` | Get min/max element | `max(Integer::compareTo)` |

---

## 📊 6. Collectors Utility

| Collector | Purpose | Example |
|------------|----------|----------|
| `toList()` | Collect to List | `collect(Collectors.toList())` |
| `toSet()` | Collect to Set | `collect(Collectors.toSet())` |
| `toMap()` | Collect to Map | `collect(Collectors.toMap(User::getId, User::getName))` |
| `joining()` | Join strings | `collect(Collectors.joining(", "))` |
| `counting()` | Count elements | `collect(Collectors.counting())` |
| `averagingInt()` | Average of int values | `collect(Collectors.averagingInt(Employee::getSalary))` |
| `groupingBy()` | Group by key | `collect(Collectors.groupingBy(Employee::getDepartment))` |
| `partitioningBy()` | Partition into two groups | `collect(Collectors.partitioningBy(x -> x > 50))` |
| `summarizingInt()` | Summary (count, sum, avg, min, max) | `collect(Collectors.summarizingInt(Employee::getSalary))` |

---

## 🧩 7. Example with Employee Class

```java
import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    String dept;
    double salary;

    Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String getDept() { return dept; }
    public double getSalary() { return salary; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return name + " (" + dept + ") - ₹" + salary;
    }
}

public class StreamCheatSheet {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee(1, "Alice", "HR", 50000),
            new Employee(2, "Bob", "IT", 70000),
            new Employee(3, "Charlie", "IT", 90000),
            new Employee(4, "David", "Finance", 60000),
            new Employee(5, "Eve", "HR", 55000)
        );

        // Filter IT employees
        List<Employee> itEmployees = employees.stream()
            .filter(e -> e.getDept().equals("IT"))
            .toList();

        // Sort by salary descending
        List<Employee> sorted = employees.stream()
            .sorted(Comparator.comparing(Employee::getSalary).reversed())
            .toList();

        // Average salary
        double avgSalary = employees.stream()
            .collect(Collectors.averagingDouble(Employee::getSalary));

        // Group by Department
        Map<String, List<Employee>> groupByDept = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDept));

        // Print results
        System.out.println("IT Employees: " + itEmployees);
        System.out.println("Sorted by Salary: " + sorted);
        System.out.println("Average Salary: " + avgSalary);
        System.out.println("Grouped by Department: " + groupByDept);
    }
}
```

---

## 🧮 8. Parallel Streams

```java
list.parallelStream()
    .filter(x -> x > 10)
    .forEach(System.out::println);
```
⚠️ Use **parallel streams** carefully — avoid shared mutable state.

---

## 🚦 9. Common Interview Questions (Detailed Explanations)

### 🧩 1. Difference between `map()` and `flatMap()`
| `map()` | `flatMap()` |
|----------|--------------|
| Transforms each element into another object. | Transforms each element into a stream, then flattens all those streams into one. |
| Returns `Stream<Stream<T>>` if you map to streams. | Returns a flattened `Stream<T>`. |
| Example: `list.stream().map(String::toUpperCase)` | Example: `listOfLists.stream().flatMap(List::stream)` |

✅ **Analogy:**  
- `map()` → “apply function to each item”  
- `flatMap()` → “apply + flatten nested structure”  

---

### 🧠 2. How does lazy evaluation work in Streams?
- Streams are **lazy** — intermediate operations (like `filter()`, `map()`) **do not execute immediately**.  
- They execute **only when a terminal operation** (like `collect()` or `forEach()`) is invoked.  
- This allows the stream to **optimize** processing and **short-circuit** results.

🧩 Example:
```java
Stream.of("A", "B", "C")
    .filter(s -> {
        System.out.println("Filtering " + s);
        return s.equals("B");
    });
```
➡️ **No output** until you call `.collect()` or `.forEach()`.

---

### ⚖️ 3. Difference between `Stream.of()` and `Arrays.stream()`
| Method | Description | Example |
|--------|--------------|----------|
| `Stream.of()` | Creates a stream from given values or an array (treats array as single element if not varargs). | `Stream.of(1,2,3)` or `Stream.of(new int[]{1,2,3})` (⚠ produces Stream<int[]>) |
| `Arrays.stream()` | Creates a stream from **array elements** (handles primitive arrays correctly). | `Arrays.stream(new int[]{1,2,3})` produces `IntStream` |

💡 **Tip:** For primitive arrays, use `Arrays.stream()`.  

---

### 🧭 4. What are Intermediate vs Terminal Operations?
| Type | Description | Examples | Return Type |
|------|--------------|-----------|--------------|
| Intermediate | Transform/Filter data, return another Stream | `map()`, `filter()`, `sorted()`, `distinct()` | Stream |
| Terminal | Produce result or side effect, consume stream | `collect()`, `count()`, `forEach()`, `reduce()` | Non-stream (e.g., int, List, Optional) |

🚨 After a terminal operation, the stream **is closed** and **cannot be reused**.

---

### ⚙️ 5. How to handle exceptions inside Streams?
You can wrap your lambda with a try-catch block or create a helper method.

Example:
```java
list.stream()
    .map(item -> {
        try {
            return riskyOperation(item);
        } catch (Exception e) {
            return "Error";
        }
    })
    .forEach(System.out::println);
```

✅ **Better practice:** Create a utility wrapper for checked exceptions using `Function<T,R>` wrappers.

---

### 🧮 6. Difference between `reduce()` and `collect()`
| Aspect | `reduce()` | `collect()` |
|--------|-------------|-------------|
| Purpose | Combine elements to produce a single value. | Accumulate elements into a collection or summary result. |
| Return Type | Single result (e.g., int, String) | Mutable container (e.g., List, Map, Statistics) |
| Example | `reduce(0, Integer::sum)` | `collect(Collectors.toList())` |

💡 Use `reduce()` for mathematical reductions; use `collect()` for aggregation or grouping.

---

### ♻️ 7. What happens if you reuse a stream?
Once a **terminal operation** is executed, the stream is **consumed and closed**.  
Attempting to reuse it throws:  
```
java.lang.IllegalStateException: stream has already been operated upon or closed
```

✅ Always **create a new stream** from the source if you need to reprocess.

---

### ⚡ 8. How does `parallelStream()` work internally?
- Uses the **ForkJoinPool** (common pool) for parallel execution.
- Divides the data into **multiple chunks** → processes them on **different threads** → merges results.
- Works best for **large, independent data sets**.
- ⚠️ Avoid when:
  - Data size is small.
  - Operations are dependent or modify shared state.
  - Using I/O-bound tasks.

💡 Example:
```java
list.parallelStream()
    .filter(x -> x > 100)
    .forEach(System.out::println);
```
