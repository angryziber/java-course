main is in def.Application.java

all unit tests are in unittests.AllTests.java

All input parameters are prompted interactively, so it should be user-friendly enough to run.
!When choosing the database input method, the competition ID, which is prompted should be either 1 or 2 (they exist in the database)

Dates are accepted only in the format from SQL database, meaning dd-mm-yyyy, not dd.mm.yyyy or dd/mm/yyyy. This is important, 
otherwise validation will not pass

Tested with java 1.6.0.1 and JUnit 3.8.1. 