# junior-homework
technical task from one of employers for junior java backend developer

Thank you for your interest in joining the 4financeIT team in Prague.

As part of the recruitment process we require you to complete a short technical task, the details for which are below. The task should take you 2-3 to complete and you have three days to complete and return the task to us. If you do not intend completing the task please let us know.

Background:

In our system client can apply for a loan by providing his personal data (e.g. first name and surname), amount and term to the system. Loan application is evaluated for potential frauds by the risk service.

Risk is considered too high in next cases:

•	An attempt to take a loan made between 00:00 to 6:00 AM with maximum possible amount.
•	The client has reached the maximum number of loan applications (i.e. 3) per day from a single IP.

Your task is to implement RiskService interface located in com.ofg.loans.service.risk package.

To successfully accomplish the task you also would need to modify Client and LoanApplication model objects.
Feel free to add your own model objects if you think they are necessary to fulfil this requirement.

Please do not change signature of the RiskService interface.

Result work evaluation is based on:
•	Code quality and test coverage
•	Implementation design
