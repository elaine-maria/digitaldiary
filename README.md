# digitaldiary : Digital Diary Documentation

A Digital Diary API to store and retrieve data to a journal


This Digital diary API  allows users to read, write, update and delete records to a diary for 2 components:-
- A Wedding Journal
- A Baby Journal

This API connects to a MySQL database hosted on the cloud to store journal data

The digital diary APIs allow for the following actions
Wedding Journal end points:- 

1: Add a new Event entry
2: Add a new Clothing entry
3: Add a new Vendor entry
4: Get details all Events
5: Get details of all Clothing
6: Get details of all Vendors
7: Get event details based on type of event
8: Update dress trial date
9: Update budget for particular event
10: Update vendor for a particular event
11: Delete a vendor


1: Add a new entry to WeddingEvents
   This request allows for creating new Wedding Events

Path:
/mydiary/wedding/newevent


Examples:

POST
{
    "eventtype": "DJSelection",
    "eventdate": "2020-06-12",
    "guestcount": 5,
    "venue": "RockHouse",
    "budget": 500

}

Response:
HTTP/1.1 201 Created
 

2: Add a new entry to WeddingClothing
   This request allows for adding entries related to Wedding Clothing

Path:
/mydiary/wedding/newclothing


Examples:

POST
{
    "dresstype": "PartyDress",
    "color": "Ivory",
    "norequired": 1,
    "boutique": "Tina's bridal",
    "budget": 500,
    "trialdates": "2020-05-02"
}

Response:
HTTP/1.1 201 Created

3: Add a new entry to WeddingVendor
   This request allows for the addition of new Vendors

Path:
/mydiary/wedding/new_vendor

Example:

{
    "vendorname": "IHOP",
    "vendortype": "Caterer",
    "budget": 3500,
    "eventhandled":1
}


Response:
HTTP/1.1 201 Created



4: Get details of all Events
   This request retrieves all the details of the various events for the Wedding

Path:
/mydiary/wedding/events

Response:
HTTP/1.1 200 OK


5: Get details of all Clothing
    This request retrieves all the clothing details of the bridal party for the Wedding

Path:
/mydiary/wedding/clothing

Response:
HTTP/1.1 200 OK

6: Get details of all Vendors
   This request retrieves all the details of the different vendors for the Wedding


Path:
/mydiary/wedding/vendors

Response:
HTTP/1.1 200 OK

7: Get event details based on type of event
   This request retrieves all the details of the events related to Wedding and vendors

Path:
/mydiary/wedding/event/{event}

Parameters: 
{event} - Event name you wish to retrieve information about

Response:
HTTP/1.1 200 OK


8: Update dress trial date
   This request updates the trial date for any of the Wedding Clothing
Path:
/mydiary/wedding/trialdate/{trialdate}/{newdate}/{dress}

Parameters:
{trialdate} - Current trial date
{newdate} - new trial date
{dress} - Dress for which date needs to be updated

Response:
HTTP/1.1 204 No Content


9: Update budget for particular event
   This request will update the budget for a particular event. It will also throw an exception if the max  budget is exceeded


Path:
/mydiary/wedding/eventbudget/{budget}/{eventtype}

Parameters:
{budget}: Amount to be updated
{event type} : Event for which budget needs to be updated

Response:
HTTP/1.1 204 No Content



10: Update vendor for a particular event
    This request updates the vendor for a given event 

Path:
/mydiary/wedding/eventhandled/{vendorname}/{event}/{vendortype}

Parameters:
{vendorname}: Vendor to be changed
{event} :  Event for which vendor needs to be changes
{vendortype}: The type of vendor for which vendor needs to be changed

Response:
HTTP/1.1 204 No Content


11: Delete a vendor
    The request can be used to delete a vendor


Path:
/mydiary/wedding/vendorname/{name}

Parameters:
{name}: Name of the vendor to be deleted

Response:
HTTP/1.1 204 No Content


Baby Journal end points:- 
1: Get all baby information
2: Get all on baby growth
3: Get all information based on a particular year
4: Get all based on name
5: Post a new growth chart
6: Post new Babyinfo


1: Get all baby information
   This requests retrieves all information from the Baby journal

Path:
/mydiary/baby/

Response:
HTTP/1.1 200 OK


2: Get all on baby growth
   This information retrieves all information from the BabyGrowthChart 

Path:
/mydiary/baby/babygrowth

Response:
HTTP/1.1 200 OK


3: Get all information based on a particular year
   This request retrieves all information for every baby for a given year

Path:
/mydiary/baby/year/{year}

Parameters:
{year}: Year from which to retrieve information

Response:
HTTP/1.1 200 OK


4: Get all based on name
   This request retrieves all information based on baby name

Path:
/mydiary/baby/name/{name}

Parameters:
{name}: Name of the baby for which to get information

Response:
HTTP/1.1 200 OK

5: Post a new growth chart
   This request adds a new entry to the BabyGrowthChart

Path:
/mydiary/baby/addgrowth

Response:
HTTP/1.1 201 Created


6: Post new Babyinfo
   This request adds a new entry to the baby journal

Path:
/mydiary/baby/addbaby

Example:

{
    "name": "John",
    "eventday": "2015-08-22",
    "description": "First haircut"
}

Response:
HTTP/1.1 201 Created	


