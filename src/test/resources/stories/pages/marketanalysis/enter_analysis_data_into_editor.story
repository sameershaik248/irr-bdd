Meta:

Narrative:
As a WEA user
I want to enter a new article into the analysis editor
So that I can post new articles

Scenario: Jane opens the market analysis editor
Given jane opens the IRR application
Given jane is logged into the WEA application with username uat.user@user.com and password password
Given jane clicked on the Market Insight link
Given jane is on the Market Insight page
Given jane is an editor and sees the POST button
When jane clicks on the POST button
Then jane sees the article editor

Scenario: Jane enters an article into the Market Insight editor to publish content
Given jane sees the article editor
When jane enters the article data into the editor and published the content
Then jane sees the article they just published on Market Insight Page

Scenario: Jane deletes the article she just entered
Given jane is on the Market Insight page
When jane clicks to Delete the current article
Then jane sees the latest Market Insight article