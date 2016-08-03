Meta:

Narrative:
As a WEA user
I want to select an article from the Market Insight index
So that I can view an older Market Insight article

Scenario: Market Insight Article Selection from Index
Given jane opens the WEA application
Given jane is logged into the WEA application with username uat.user@user.com and password password
Given jane clicked on the Market Insight link
Given jane is on the Market Insight page
When jane selects the second article from the index
Then jane sees the second Market Insight article