---
description: >-
  The internet was done so well that most people think of it as a natural
  resource like the Pacific, rather than something man-made. When was the last
  time a technology with a its scale being error free
---

# Reliable, Scalable & Maintainable

### Features

1. **Reliability**: Tolerating hardware & software faults. Human error.
2. **Scalability**: Measuring load & performance. Latency percentiles, throughput.
3. **Maintainability**: Operability, simplicity & evolvability.

### Examples

1. Store data so that they, or another application, can find it again later (databases)&#x20;
2. Remember the result of an expensive operation, to speed up reads (caches)
3. Allow users to search data by keyword or filter it in various ways (search indexes)
4. Send a message to another process, to be handled asynchronously (stream processing)
5. Periodically crunch a large amount of accumulated data (batch processing)

Increasingly, many applications now have such demanding or wide-ranging requirements that a single tool can no longer meet all of its data processing and storage needs. Instead, the work is broken down into tasks that can be performed efficiently on a single tool, and those different tools are stitched together using application code.

### Faults

1. Uncorrelated hardware faults
   1. Hardware faults are usually random & independent. One machine failing does not imply another machine is going to fail.&#x20;
   2. Except for common causes like the temperature in the server rack, it's unlikely that a large number of hardware components will fail concurrently.
2. Correlated across nodes
   1. A software bug that causes every instance of an application server to crash when given a particular bad input.
   2. A runaway process that uses up some shared resource- CPU time, memory, disk space, or network bandwidth.
   3. A service that the system depends on that slow down, becomes unresponsive, or starts returning corrupted resources.
   4. Cascading failures, where a small fault in one component triggers a fault in another component, which in turn triggers further faults.

Note that a fault is not the same as a failure. A fault is usually defined as one component of the system deviating from its spec, whereas a failure is when the system as a whole stops providing the required service to the user. It is impossible to reduce the probability of a fault to zero; therefore it is usually best to design fault-tolerance mechanisms that prevent faults from causing failures.

#### Some precautionary measures

1. Think about assumptions & interactions in the system.
2. Thorough testing
3. Process isolation
4. Allowing process to crash & restart
5. Measuring, monitoring & analysing behaviour in production.

If a system is expected to provide some guarantee, it can constantly check itself while it is running & raise an alert if a discrepancy is found.

Humans are known to be unreliable.

If  the interfaces are too restrictive, people will work around them, negating their benefit. A tricky balance to get right.

There are situations in which we may choose to sacrifice reliability in order to reduce development or operational cost- but we should be very conscious of when we are cutting corners.

### Load parameters

Best choice of parameters depends on the architecture of the system.

1. requests/second to a web server.
2. ratio of reads to writes in a database.
3. no of simultaneously active users.
4. hit rate on a cache.

Perhaps the average case is what matters to you, or perhaps your bottleneck is dominated by a small no of extreme cases.

### **The Twitter Feed: Nov 2012**

Challenge: Deliver tweets to followers within 5 seconds.

Post Tweet: 4.6k req/sec; Home Timeline: 300k req/sec.

1. Map each tweet to the user. Fetch tweets of all the followers for the user and return the merged list.
   1. Heavy operation while fetching tweets.
2. Separate cache for each User. After a tweet is posted, insert the tweet into all the followers caches.
   1. Heavy operation while creating tweet.
3. For users with few followers, caching is feasible but for users with millions of followers, caching is skipped & those tweets are fetched while fetching the timeline and sent out as the response using the combination of caches and db queries.

### Latency & Response time

Response time is what the client sees for the request completion. Besides the actual time to process the request, it includes network delays & queuing delays.

Latency is the duration that a request is waiting to be handled; during which the request is latent, awaiting service.

1. Average response time: not a good metric as doesn't tell how many users actually experiences delays.
2. Median is the next best thing as it separates at 50% users. If a user makes several requests, the probability that at least one of them is slower than the median is much greater than 50%.
3. Higher percentiles like 95th, 99th & 99.9th percentiles are also common. Aka tail latencies. Directly affect users' experience of the service.
4. Reducing response times at very high percentiles like 99.99th is difficult because they are easily affected by random events outside of your control, and the benefits are diminishing.

When generating load artificially in order to test the scalability of a system, the load generating client needs to keep sending requests independent of response time. If the client waits for previous request to complete before sending the next one, that behaviour has the affect of artificially keeping the queues shorter in the test than they would be in reality, which skews the measurements.

Even if only a small percentage of backend calls are slow, the chance of getting a slow call increases if an end-user request does multiple backend calls. Even if they run in parallel, the end user request still needs to wait for the slowest of the parallel calls to completer. When a higher proportion of requests end-up being slow, it is known as tail latency amplification.

### Amazon Latency Requirements.

1. &#x20;Internal services as 99.9th percentile. 1 in 1000 requests.
2. Slowest requests are often those who have the most data on their accounts because they have made many purchases. Most valuable customers
3. 100 ms increase in response times reduces sales by 1%.&#x20;
4. 1 sec slowdown reduces customer satisfaction metric by 16%.

### Approaches for Scaling

While distributing stateless services across multiple machines is fairly straightforward, taking stateful data systems from a single node to a distributed setup can introduce a lot of additional complexity. For this reason, common wisdom until recently was to keep your db on  a single node and scale it up until scaling cost or high-availability requirements forced you to make it distributed.

If is conceivable that distributed data systems will become the default in the future, even for use cases that don't handle large volumes of data or traffic.

The architecture of systems that operate at large scale is usually high specific to the application. there is no such  thing as a generic, one-size-fits-all scalable architecture.&#x20;

The problems may be&#x20;

1. the volume of reads
2. the volume of writes
3. the volume of data to store
4. the complexity of the data
5. the response time requirements
6. the access patterns
7. or some mixture of all these plus many more issues.

An architecture that scales well for a particular application is built around the assumptions of which operations will be common and which will be rare.

### Making life easy for Operations

Good operations can often work around the limitations of bad (or incomplete) software, but good software cannot run reliably with bad operations.

#### Typical responsibilities:

1. Monitor health & quickly restore bad services.
2. Track down cause of problems.
3. Keeping everything up to date, including security patches.
4. Keeping tabs on the system interactions.
5. Anticipating future problems & dealing with them.
6. Establish practices & tools for deployment, configuration management.
7. Perform complex tasks like moving an application from one platform to another.
8. Define processes that make operations predictable and keep production stable.
9. Preserving the org's knowledge about the system, independent of who worked.

#### Things Data Systems do to make routine tasks easy.

1. Visibility to runtime behaviour & internals.
2. Support for automation & integration with standard tools.
3. Avoid dependency on individual machines.
4. Easy-to-understand operational model.
5. Self-healing when appropriate.
6. Admins with controls to override the system.
7. Exhibits predictable behaviour, minimising surprises.

Reducing complexity greatly improves maintainability, making simplicity the end-goal.

Making a system simpler doesn't mean reducing its functionality, it also mean removing accidental complexity. Accidental complexity is not inherent in the problem that the software solves but arises only from the implementation.

The ease with which you can modify a data system, and adapt it to changing requirements, is closely linked to its simplicity and its abstractions. Aka evolvability.



There is unfortunately no easy fix for making applications reliable, scalable, or maintainable. However, there are certain patterns and techniques that keep reappearing in different kinds of applications.
