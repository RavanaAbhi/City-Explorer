# City Explorer 🌍 (Enterprise Reference Blueprint)

An offline-first, highly optimized, multi-module Android reference project built using **Jetpack Compose**, **Clean Architecture**, and strict **Unidirectional Data Flow (MVI)** patterns.

This repository serves as a modular boilerplate baseline designed for enterprise scaling, featuring strict structural code governance, automated continuous integration gates, and secure transaction workflows.

## 🏗️ Architectural Topology
This platform utilizes a decoupled **Feature-by-Feature Modularization** strategy to optimize build caching pipelines, reduce incremental compilation times, and enforce hard project layer boundaries.

┌─────────────────────────────┐
│      :app (Orchestrator)    │
└──────────────┬──────────────┘
│
┌────────────────────┴────────────────────┐
▼                                         ▼
┌─────────────────────────┐               ┌─────────────────────────┐
│ :feature:explorer       │               │ :feature:payment        │
│ (Compose UI, Local Data)│               │ (RazorPay Integration)  │
└─────────────┬───────────┘               └─────────────┬───────────┘
│                                         │
└────────────────────┬────────────────────┘
▼
┌─────────────────────────────┐
│      :core:designsystem     │
│  (Token-Driven UI Structure)│
└──────────────┬──────────────┘
▼

┌─────────────────────────────┐
│      :core:network          │
│  (SSL Pinning & Remote Sync)│
└─────────────────────────────┘

## 🔒 Automated System Governance & Security
- **CI/CD Quality Gate:** Automated via GitHub Actions (`android-ci.yml`), validating compilation, unit-testing suites, and static structure on every pull request.
- **Static Analysis Execution:** Integrates `Detekt` directly into compilation tasks to systematically intercept code smell anomalies before branch merges.
- **Secrets Sandboxing:** Zero API token persistence within version control; variables are safely queried from system level environmental scopes via `local.properties`.
- **Performance Compilation:** Automatic configuration mappings generate **Compose Compiler Stability Reports** directly to trace and bypass potential rendering re-composition leaks.

## 🛠️ Tech Stack & Capabilities
- **UI Framework:** Jetpack Compose (100% Declarative UI)
- **Asynchronous Execution:** Kotlin Coroutines & Flow API structures
- **Dependency Inversion:** Jetpack Hilt / Dagger
- **Integration Framework:** Native RazorPay Payment Gateway Component Integration