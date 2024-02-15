Feature: Search News Articles

    Background: Access altoromutual url and access Search News Articles page
        Given I access the Altoro Mutual URL
        And I login with username "jsmith" and password "Demo1234"
        And I access the Search News Articles page

    Scenario: Search for existing titles using keywords
        When I type <keyword> on search input field
        And I click on Query button 
        Then the corresponding article with the title <article> should be displayed

        Examples:
        |           keyword              |       article         |
        |           "Unix"               |   "Unix was created"  |
        |           "Born"               |   "Jesus was Born"    |
        |   "Availability of AppScan"     |   "Watchfire Announces General Availability of AppScan QA for Mercury TestDirector"   |


    