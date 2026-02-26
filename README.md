# POC Architecture Styles

Hands-on exploration of software architecture styles using a single domain: **Job Orchestrator**.

This repository implements the same business domain using different architectural styles in order to compare trade-offs, modularity, scalability, complexity, and maintainability.

The goal is not just to study theory, but to experience how architecture decisions shape real systems.

---

## 🎯 Objective

To deeply understand architectural styles by:

- Applying each style to the same domain
- Observing trade-offs in practice
- Comparing structural differences
- Documenting architectural decisions
- Evaluating scalability, coupling, and evolution complexity

---

## 🧠 Domain: Job Orchestrator (Mini)

A simplified job processing system that:

- Creates jobs
- Starts execution
- Processes steps
- Updates job status
- Retrieves execution history

### Core States

- CREATED
- RUNNING
- SUCCESS
- FAILED

This same domain will be implemented across all architectural styles.

---

## 🏗 Architectural Styles Implemented

- `poc-layered-architecture`
- `poc-pipeline-architecture`
- `poc-microkernel-architecture`
- `poc-event-driven-architecture`
- `poc-space-based-architecture`
- `poc-microservices-architecture`

Each project is self-contained and demonstrates how the same business rules behave under different structural approaches.

---

## 📊 What Is Being Compared?

For each architectural style:

- Modularity
- Coupling
- Cohesion
- Scalability
- Resilience
- Deploy complexity
- Evolution cost
- Testability

---

## 📚 Learning Approach

For each architecture:

1. Study the theory
2. Design the system
3. Implement the MVP
4. Document decisions (ADR)
5. Reflect on trade-offs

---

## 🚀 Tech Stack

- Java
- Spring Boot
- Maven / Gradle
- REST APIs
- Basic persistence (depending on style)

---

## 📌 Why This Repository Exists

Understanding architecture requires more than reading about it.

It requires building it.

This repository is a practical lab to internalize architectural thinking and decision-making.

---

## 📎 Future Improvements

- Add C4 diagrams
- Add ADR documentation
- Add load tests
- Add comparison matrix
- Add deployment variations (Docker/K8s)

---

## 🧩 Status

Work in progress — new architectural styles will be implemented progressively.
