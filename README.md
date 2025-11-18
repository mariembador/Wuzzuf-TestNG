# TestNGFinalProject — UI Test Automation (Selenium + TestNG + Maven)

End-to-end UI test suite for Wuzzuf flows using Selenium WebDriver, TestNG, and ExtentReports. The project follows the Page Object Model (POM) and runs on Microsoft Edge with an AdBlock extension preloaded to reduce noisy popups/ads during runs.

## Description

This repository contains a maintainable UI test automation suite that validates key user journeys on https://wuzzuf.net, including account registration, general information setup, education and experience details, expertise selection, career preferences, and homepage interactions. Tests are built with the Page Object Model for readability and reuse, generate realistic input data with JavaFaker, and produce rich HTML results via ExtentReports.

Execution targets Microsoft Edge using WebDriverManager to automatically provision the matching EdgeDriver. An AdBlock extension is loaded at startup to minimize flaky ad/pop-up interruptions during runs. You can execute the full flow through the TestNG suite file (`runner/chrome/wuzzuf.xml`) or run individual classes/groups via Maven or your IDE.

## What’s inside

- Selenium 4 + WebDriverManager for automatic EdgeDriver handling
- TestNG test framework with suite XML runner
- Page Object Model under `src/main/java/Pages`
- Rich HTML reports via ExtentReports at `reports/report.html`
- JavaFaker to generate realistic test data on the fly

## Tech stack

- Java 23 (source/target)
- Maven (build + test)
- Selenium 4.27.0
- TestNG 7.10.2
- WebDriverManager 5.9.2
- ExtentReports 5.1.1
- JavaFaker 1.0.2

## Project structure

```
TestNGFinalProject/
├─ pom.xml
├─ reports/
│  └─ report.html                  # ExtentReports output (generated at runtime)
├─ runner/
│  └─ chrome/
│     └─ wuzzuf.xml               # TestNG suite file (class order / selection)
├─ src/
│  ├─ main/
│  │  ├─ java/
│  │  │  └─ Pages/                # Page Objects (POM)
│  │  │     ├─ careerPage.java
│  │  │     ├─ educationPage.java
│  │  │     ├─ experiencePage.java
│  │  │     ├─ expertisePage.java
│  │  │     ├─ homePage.java
│  │  │     ├─ infoPage.java
│  │  │     └─ registerPage.java
│  │  └─ resources/
│  │     └─ AdBlock-—-block-ads-across-the-web-Chrome-Web-Store.crx
│  └─ test/
│     └─ java/
│        └─ Tests/                # TestNG tests + base
│           ├─ careerTest.java
│           ├─ educationTest.java
│           ├─ experienceTest.java
│           ├─ expertiseTest.java
│           ├─ homeTest.java
│           ├─ infoTest.java
│           ├─ registerTest.java
│           └─ testBase.java      # WebDriver + reporting setup (Edge)
└─ target/                        # Maven build output (generated)
```

## Prerequisites

- JDK 23 installed and on PATH (JAVA_HOME set)
- Maven 3.9+ installed and on PATH
- Microsoft Edge installed (WebDriverManager downloads the matching driver automatically)

No manual WebDriver download is required.

## Setup

1) Verify Java and Maven

```bat
java -version
mvn -version
```

2) Install dependencies (Maven will do this on the first run automatically)

```bat
mvn -q dependency:resolve
```

## How to run

The suite is defined at `runner/chrome/wuzzuf.xml` and lists the tests to execute in order.

- Run the full suite via Maven (recommended):

```bat
mvn -Dsurefire.suiteXmlFiles=runner/chrome/wuzzuf.xml test
```

- Run a single TestNG class:

```bat
mvn -Dtest=Tests.registerTest test
```

- Run tests by TestNG group (example: the `createAccount` group in `registerTest`):

```bat
mvn -Dgroups=createAccount test
```

- Run from your IDE
  - Import as a Maven project.
  - Right-click the `wuzzuf.xml` suite and run it with TestNG.
  - Or run individual test classes/methods directly.

## Reports

- ExtentReports: Generated at `reports/report.html`. The suite automatically flushes the report at the end, and on desktop environments it attempts to open the HTML file for you.
- TestNG/Surefire: Additional XML/HTML output under `target/surefire-reports`.

## Key implementation notes

- Browser: Microsoft Edge is configured in `Tests/testBase.java` using `EdgeOptions`.
- AdBlock extension: Loaded from `src/main/resources/AdBlock-—-block-ads-across-the-web-Chrome-Web-Store.crx` to minimize ad-driven UI noise.
- Base URL: Tests navigate to `https://wuzzuf.net/jobs/egypt` and continue through registration/profile flows.
- Data generation: `com.github.javafaker` provides randomized but realistic names, emails, and job titles.

## Troubleshooting

- Java version error (e.g., “invalid target release: 23”)
  - Install JDK 23, set `JAVA_HOME`, and ensure `java -version` reports 23.
  - Alternatively, lower `<maven.compiler.source/target>` in `pom.xml` to match your installed JDK (not recommended if you don’t need to).

- Browser/driver issues
  - Ensure Microsoft Edge is installed and up to date.
  - WebDriverManager will download the matching EdgeDriver automatically; if behind a proxy, configure JVM proxy settings.

- Report doesn’t open automatically
  - On some environments (e.g., headless/CI), the call to open the file via `Desktop` is blocked. You can open `reports/report.html` manually after the run.

- UI locators failing
  - Public websites change; if a locator breaks, update the corresponding `Pages/*.java` file. Re-run to confirm stability.

## Extending the suite

- Add a new Page Object under `src/main/java/Pages`.
- Create a corresponding test under `src/test/java/Tests` (extend `testBase`).
- Wire it into `runner/chrome/wuzzuf.xml` to include it in the suite order.

## License

This repository doesn’t define a license. If you plan to share or reuse, consider adding a LICENSE file.