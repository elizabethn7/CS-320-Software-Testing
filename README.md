# CS 320 Software Testing Portfolio

This repository contains artifacts from my CS 320 Software Testing course. These projects demonstrate my experience developing back-end services, creating JUnit tests, analyzing software requirements, and applying testing strategies to improve software quality.

## How can I ensure that my code, program, or software is functional and secure?

I can ensure that my software is functional by testing it against its requirements instead of assuming that code is correct simply because it compiles or works under normal conditions. During this course, I used JUnit tests to check valid inputs, invalid inputs, boundary conditions, and service operations. Testing unexpected inputs is especially important because it can reveal errors that may not appear during normal use. I can also improve security by validating input, handling errors appropriately, reviewing code carefully, and continuing to test software whenever changes are made.

## How do I interpret user needs and incorporate them into a program?

I interpret user needs by turning requirements into specific behaviors that the software must perform. For example, the Contact service had requirements for the maximum length of names and addresses and required phone numbers to contain exactly 10 digits. I used those requirements when designing both the Contact class and its JUnit tests. Breaking larger user requirements into smaller, testable conditions helps me verify that the finished program actually meets the user's expectations.

## How do I approach designing software?

I approach software design by first understanding the requirements and then dividing the problem into smaller components with clear responsibilities. I also consider how those components will be tested while I am designing them. In this project, separating the Contact object from the ContactService made it easier to test validation and service operations independently. I have learned that testing should not be treated as something that happens only after development is complete. Designing software with testing and maintainability in mind can make problems easier to identify and make future changes safer.
