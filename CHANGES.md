- startTime and endTime of a show
- Language in a Show and not Movie
- Enum for Languages
- Class for Cast
- Made payment class abstract
- Child classes of Payment calling super in constructor

- Synchronize the whole method
- Take a lock of show (or showId)
- Take a lock at showSeatId level
  - take lock in an ascending order to ensure, in case
  - of conflicts, atleast 1 thread is able to do the work.
- Assignment:
  - Imlement a concurrency manager that gives the lock to the
  - request that had more seats in case of a conflict

// By Wednesday -> TA