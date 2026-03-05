# POC Architecture Styles

Hands-on exploration of **software architecture styles** through
practical implementations in Java and Spring.

This repository contains multiple **small systems**, each designed to
highlight the strengths, trade-offs, and structural characteristics of a
specific architectural style.

The goal is not only to study theory, but to **experience how
architecture decisions shape real systems**.

------------------------------------------------------------------------

# 🎯 Objective

To deeply understand architectural styles by:

-   Implementing real systems using different architectures
-   Observing trade-offs in practice
-   Comparing structure, coupling, and complexity
-   Documenting architectural decisions
-   Understanding when each style should (and should not) be used

This repository acts as a **practical architecture laboratory**.

------------------------------------------------------------------------

# 🧠 Learning Strategy

For each architecture style:

1.  Study the theory
2.  Design a simple domain that fits the architecture
3.  Implement a working MVP
4.  Document architectural decisions (ADR)
5.  Reflect on trade-offs and limitations

------------------------------------------------------------------------

# 🏗 Architecture Styles Implemented

Each folder contains a **self-contained project** implementing a
specific architecture.

------------------------------------------------------------------------

# 1️⃣ Layered Architecture

📂 `poc-layered-architecture`

### Domain: Job Orchestrator (Mini)

A simplified job processing system:

-   Create jobs
-   Start execution
-   Process steps
-   Update job status
-   Retrieve execution history

### Why this architecture fits

Layered architecture works well for **traditional business
applications** where the focus is clear separation between:

-   Presentation
-   Business logic
-   Persistence

### Learning goals

-   Understand technical layering
-   Identify common anti-patterns (Architecture by Implication)
-   Observe coupling between layers

------------------------------------------------------------------------

# 2️⃣ Pipeline Architecture

📂 `poc-pipeline-architecture`

### Domain: Job Execution Pipeline

A job execution flow modeled as a **pipeline of processing steps**:

Example pipeline:

    Validate Job
        ↓
    Prepare Context
        ↓
    Execute Step
        ↓
    Update Status
        ↓
    Persist Result

### Why this architecture fits

Pipeline architecture is ideal for **sequential processing flows**,
where each stage transforms data.

Examples in real systems:

-   Compilers
-   Data processing
-   ETL pipelines
-   Request processing chains

### Learning goals

-   Understand pipeline orchestration
-   Compare with Template Method / Chain of Responsibility
-   Observe pipeline extensibility

------------------------------------------------------------------------


# 4️⃣ Service-Based Architecture (SBA)

📂 `poc-service-based-architecture`

### Domain: Account & Orders

A simple business system with two main capabilities:

-   Identity (users and authentication)
-   Orders (purchase management)

### Services

-   **Identity Service**
-   **Orders Service**
-   **BFF API**
-   **API Gateway (Spring Cloud Gateway)**

Architecture flow:

    Client
       ↓
    API Gateway
       ↓
    BFF
       ↓
    Services
       ├─ Identity Service
       └─ Orders Service

### Characteristics

-   Services represent **coarse-grained business capabilities**
-   Services **share the same database instance** (different schemas)
-   BFF composes data for the UI
-   Communication mostly via REST

### Learning goals

-   Understand the middle ground between **monolith and microservices**
-   Study **API Gateway + BFF patterns**
-   Understand database ownership in distributed services

------------------------------------------------------------------------

# 5️⃣ Event-Driven Architecture

📂 `poc-event-driven-architecture`

### Domain: Order Processing with Events

An order processing system where services communicate via **events
instead of direct calls**.

Example flow:

    Order Created
          ↓
    Payment Service processes payment
          ↓
    Payment Approved Event
          ↓
    Inventory Service reserves stock
          ↓
    Notification Service sends confirmation

### Technologies

-   Kafka / Redpanda
-   Event producers
-   Event consumers

### Learning goals

-   Understand asynchronous communication
-   Study event choreography
-   Explore eventual consistency

------------------------------------------------------------------------

# 6️⃣ Space-Based Architecture

📂 `poc-space-based-architecture`

### Domain: Real-Time Counter / Metrics System

A system designed to handle **high traffic updates** without relying
heavily on a central database.

Example use case:

-   Real-time view counter
-   Live metrics aggregation
-   Session tracking

Architecture concept:

    Client requests
           ↓
    Processing Unit
           ↓
    In-Memory Data Grid
           ↓
    Async persistence

### Characteristics

-   State stored in memory
-   Horizontal scalability
-   Reduced database bottlenecks

### Learning goals

-   Understand in-memory data grids
-   Study scalability patterns
-   Explore distributed state management

------------------------------------------------------------------------

# 7️⃣ Microservices Architecture

📂 `poc-microservices-architecture`

### Domain: E-Commerce Mini

A small e-commerce system split into independent microservices:

Services:

-   Identity Service
-   Product Catalog Service
-   Orders Service
-   Payment Service
-   Notification Service

Each service:

-   Owns its **own database**
-   Communicates via **REST or events**
-   Can be deployed independently

### Learning goals

-   Understand service autonomy
-   Study data ownership
-   Explore distributed system challenges

------------------------------------------------------------------------

# 📊 What Is Being Compared?

Across architectures we observe:

-   Modularity
-   Coupling
-   Cohesion
-   Scalability
-   Resilience
-   Deployment complexity
-   Operational cost
-   Evolution difficulty

------------------------------------------------------------------------

# 🚀 Tech Stack

-   Java 21
-   Spring Boot
-   Spring Cloud Gateway
-   Kafka / Redpanda (for event-driven)
-   Docker
-   REST APIs
-   Basic persistence (PostgreSQL or H2 depending on architecture)

------------------------------------------------------------------------

# 📚 Why This Repository Exists

Understanding architecture requires more than reading books.

It requires **building systems and experiencing trade-offs**.

This repository is a **hands-on architecture laboratory** designed to
internalize architectural thinking and decision-making.

------------------------------------------------------------------------

# 📌 Future Improvements

-   Add **C4 diagrams**
-   Add **ADR documentation**
-   Add **architecture comparison matrix**
-   Add **performance/load tests**
-   Add **deployment variations (Docker/Kubernetes)**

------------------------------------------------------------------------

# 🧩 Status

Work in progress --- architectures will be implemented progressively as
part of a continuous learning journey.
