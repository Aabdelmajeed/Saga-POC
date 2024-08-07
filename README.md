## POC Repo for implementing SAGA Pattern
> # Advantages of Saga Pattern
---
> 1. Improved Fault Tolerance:
Since sagas break down transactions into smaller steps, failures in one step don’t necessarily lead to the entire transaction failing.
Compensation transactions help to maintain a consistent state, even in the presence of failures.
> 2. Scalability:
Distributed systems can scale more effectively as sagas allow for parallel processing of steps across multiple services.
> 3. Consistency:
The pattern ensures that the system remains in a consistent state, regardless of the failures during the execution of individual steps.
https://medium.com/@nikhiltjha/understanding-the-saga-pattern-in-distributed-systems-1325ce50ffa1
