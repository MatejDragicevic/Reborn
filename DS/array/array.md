# Arrays

Multiple values in a single variable of the same type with a given predefined number of values.
Values are indexed from 0 to n - 1(n is 10 means 0,1,2...9).

## Pros

- Multiple data of same type.
- Random access is possible at O(1) using the index if known.
- Uses contigous memory locations for memory allocations which prevents memory overflow.
- Two-dimensional arrays can be used to represent matrices.
- Delete last element is O(1)

## Cons

- Number of elements must be known ahead of time.
- Fixed size, as in once declared it cannot be modified in size
- Insertion and deletion are expensive

## Applications

- store data of same type
- multiple variables in one
- sorting data elements
- matrix operations