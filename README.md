# 🔐 Login Page Automation + Database Validation (Selenium, TestNG, JDBC)

This repository contains automation scripts for testing login functionality via the UI using Selenium, with back-end validation of credentials using JDBC to connect to a relational database (e.g., MySQL).
Each login scenario checks not only the front-end response but also verifies the correctness of credentials against the actual database values.

---

## 🧪 Test Cases Covered

| Test Case ID | Description                                           | Expected Outcome                      |
|--------------|-------------------------------------------------------|---------------------------------------|
| TC001        | Valid username + valid password                      | Login successful, DB match            |
| TC002        | Valid username + invalid password                    | Login failure, DB shows mismatch      |
| TC003        | Invalid username + valid password                    | Login failure, DB fetch fails/null    |
| TC004        | Invalid username + invalid password                  | Login failure, DB fetch fails/null    |
| TC005        | Empty username + password                            | Show error, DB call skipped           |

📌 Each test validates both:
- **Frontend message/response**
- **Backend DB state using JDBC query**

---

## 🛠️ Tech Stack

| Tool         | Use                                |
|--------------|-------------------------------------|
| Java         | Programming Language                |
| Selenium     | Browser Automation                  |
| TestNG       | Test Execution Framework            |
| JDBC         | Database Connectivity (MySQL/H2)    |
| Maven        | Dependency Management               |
| Eclipse/VS Code | IDE for development             |

---
## 🖼 Screenshot Handling

📸 Screenshots are captured:
- Automatically on test **failures**
- Stored in the `/screenshots` folder
- Useful for debugging failed tests

---

## 🧠 Database Query Example
<pre>
```sql
SELECT password FROM users WHERE username = ?;
'''
/*This is used to fetch the stored password for a given username and validate it against the one entered in the test.*/
'''
</pre>
💻 How to Run the Tests
Clone the repo:

Copy Edit : git clone https://github.com/charishma0623/Sele_Practice.git

Update your DB credentials in config.properties(optional but is organized)

Add JDBC driver (e.g., mysql-connector-java) in pom.xml

Run the test suite:

Via testng.xml

Or directly from Eclipse → Run As → TestNG Suite

✅ Assertions Used

UI Validation: check success/failure messages

DB Validation: Assert.assertEquals(expectedDBValue, actualInput)

Screenshot on failure via TestNG listeners or try-catch blocks
