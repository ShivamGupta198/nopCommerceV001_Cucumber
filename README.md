"# nopCommerceV001_Cucumber" 

From Intellij Terminal:-
First Step:-
mvn clean

Second Step:-
mvn install -Dbrowser=chrome -Dwebdriver.chrome.driver="C:\Users\SHIVAM GUPTA\workspaceLatest\nopCommerceV001_Cucumber\Drivers\chromedriver.exe" -Denv=qa01

For running from Runner add below line in VM Arguments:-

-Dbrowser=chrome -Dwebdriver.chrome.driver="C:\Users\SHIVAM GUPTA\workspaceLatest\nopCommerceV001_Cucumber\Drivers\chromedriver.exe" -Denv=qa01
