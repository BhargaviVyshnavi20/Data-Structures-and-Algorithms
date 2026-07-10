# Contributing Guidelines

Thank you for your interest in contributing! 

By sharing your solutions, you're helping build a well-organized, community-driven repository for learning **Data Structures and Algorithms**. To keep the repository clean, consistent, and easy to navigate, please follow the guidelines below before submitting a Pull Request.

---

# 1. Directory Structure & File Naming

Please place your solution in the correct directory based on the programming language, DSA topic, and difficulty level.

## Directory Structure

```text
/[Language]/[DSA_Topic]/[Difficulty]/[ProblemName].[extension]
```

### Example

```text
Java/Arrays/Easy/TwoSum.java
Python/LinkedList/Medium/reverse_linked_list.py
```

---

## File Naming Conventions

### Java

Use **PascalCase** for filenames.

✅ Correct

```text
TwoSum.java
ValidParentheses.java
ReverseLinkedList.java
```

### Python

Use **snake_case** for filenames.

✅ Correct

```text
two_sum.py
valid_parentheses.py
reverse_linked_list.py
```

### Competitive Programming Exception

Some platforms (such as **Codeforces**) require the main class to be named `Main`.

In such cases, you may use the following structure:

```text
Java/
└── Arrays/
    └── Easy/
        └── Problem_123A/
            └── Main.java
```

This keeps the repository organized while satisfying platform requirements.

---

# 2. Code Quality Requirements

Every solution **must** include a comment block at the top containing:

- Problem Link
- Time Complexity
- Space Complexity
- Short explanation of the approach (2–3 lines)

---

## Java Example

```java
// Problem Link: https://leetcode.com/problems/two-sum/
// Time Complexity: O(N)
// Space Complexity: O(N)
//
// Approach:
// Use a HashMap to store previously seen elements.
// For each number, check whether its complement already exists.

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // Solution
    }
}
```

---

# 3. Git Workflow (How to Submit)

## Step 1: Fork the Repository

Click the **Fork** button at the top-right corner of this repository.

---

## Step 2: Clone Your Fork

```bash
git clone https://github.com/YOUR_USERNAME/Data-Structures-and-Algorithms.git
```

---

## Step 3: Create a New Branch

Create a separate branch for your contribution.

```bash
git checkout -b feature/solve-problem-name
```

Example:

```bash
git checkout -b feature/two-sum-java
```

---

## Step 4: Add Your Solution

Place your solution inside the correct directory following the repository structure.

Example:

```text
Java/Arrays/Easy/TwoSum.java
```

---

## Step 5: Commit Your Changes

Use a meaningful commit message.

```bash
git commit -m "Add Java solution for Two Sum in Arrays/Easy"
```

---

## Step 6: Push Your Branch

```bash
git push origin feature/solve-problem-name
```

---

## Step 7: Open a Pull Request

Go to your fork on GitHub and click **New Pull Request**.

Provide a clear title and brief description of your contribution.

---

# ✅ Pull Request Checklist

Before submitting your PR, make sure you have:

- Placed the file in the correct directory.
- Followed the required file naming convention.
- Added the problem link.
- Included time complexity.
- Included space complexity.
- Added a brief explanation of your approach.
- Ensured the code compiles and runs correctly.
- Used a meaningful commit message.

---

# Important

Pull Requests that:

- Break the repository structure
- Use incorrect file names
- Omit complexity analysis
- Lack a problem link
- Contain non-working code

will be requested for changes before they can be merged.

---

# Thank You

Every contribution—whether it's fixing a typo, improving documentation, or adding a new solution—helps make this repository better for everyone.

