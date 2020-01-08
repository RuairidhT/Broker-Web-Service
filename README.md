# Broker-Web-Service

The goal of this coursework is to demonstrate an understanding of using Service Oriented Architecture principles in software applications integration. In the first section, you will utilise web services to compose a Shares Brokering system. The Shares Brokering system consists of a shares acquisition service that you should build yourself and an external currency conversion service that you need to consume and integrate with the shares acquisition service; both services can be complemented by consuming external APIs. The research element of the coursework investigates using advanced (semantic-based) techniques to further extend your application.

## A - Core Web Service (weighting - 30%)
### 1. Implement Shares Brokering service
a) Current shares on trade should be held in an XML file based on an XSD schema containing: company name, company symbol on the stock exchange, number of available shares, a complex ‘share_price’ element containing currency and value, and date of the last-update of the share price.
b) The web service should allow users to list shares details and update the number of shares on offer when a purchase is made. You might opt to utilise JAXB to generate helper Java classes, which allow reading and populating the XML documents.
c) Implement a search functionality allowing customers to list shares’ offerings using various criteria such as company details, highest price, etc. More sophisticated search functionality will merit higher marks. 

## B – Web Service Composition (weighting - 30%)
### 2. Integrate currency conversion service
Download the pre-coded project with the currency conversion web service from the module’s NOW room site and deploy it. Consume the currency conversion service in the shares brokering service to auto-convert the share price rate to the rate preferred by the customer. 

### 3. Extend functionality by utilising external REST APIs 
Research and utilise external RESTful service to extend the functionality of your shares
brokering system. Example of such service can be:

• A service that returns up-to-date currency exchange rate. Use the service to update
the exchange rate of your currency conversion service.

• A service that returns the latest share value quote for a particular company. Similarly, you can use the service to update the share value held in your Shares Broker XML file.

In order to achieve the highest marks, you must show initiative and inventiveness beyond the stated specification. Examples include utilising additional external REST APIs, creating user accounts for clients allowing them to sell shares back to the brokering service, implementing non-java clients to demonstrate SOA’s platform independence, etc.

## C – Analysis of Quality of services ‘QoS’ (weighting - 20%)
Referring to your implementation, describe SOA Web Services’ performance and scalability challenges, in particular with the increase in service demand - such as the number of concurrent client connections and the size of the payload (response messages). Highest marks will be awarded to submissions that perform physical QoS testing for the developed application.Explain how Cloud Computing provision can address these issues, and referring to the deployment model, elaborate on the challenges accompanying migration to the Cloud Infrastructure.
