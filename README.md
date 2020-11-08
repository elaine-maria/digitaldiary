# Digital Diary API Documentation


>**A Digital Diary API to store and retrieve data to a journal.**

**This Digital diary API  allows users to read, write, update and delete records to a diary for 2 components**
- A Wedding Journal
- A Baby Journal

> **This API connects to a MySQL database hosted on the cloud to store journal data**

Wedding Journal end points

-  Add a new Event entry
-  Add a new Clothing entry
-  Add a new Vendor entry
-  Get details all Events
-  Get details of all Clothing
-  Get details of all Vendors
-  Get event details based on type of event
-  Update dress trial date
-  Update budget for particular event
-  Update vendor for a particular event
-  Delete a vendor



**Add a new entry to WeddingEvents :**  
This request allows for creating new Wedding Events

Path:  
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;/mydiary/wedding/newevent  

Example:

```
POST
{
    "eventtype": "DJSelection",
    "eventdate": "2020-06-12",
    "guestcount": 5,
    "venue": "RockHouse",
    "budget": 500
}
```  

Response:  
HTTP/1.1 201 Created



**Add a new entry to WeddingClothing :**  
This request allows for adding entries related to Wedding Clothing

Path:  
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;/mydiary/wedding/newclothing 

Example:

```
POST
{
    "dresstype": "PartyDress",
    "color": "Ivory",
    "norequired": 1,
    "boutique": "Tina's bridal",
    "budget": 500,
    "trialdates": "2020-05-02"
}
```  

Response:  
HTTP/1.1 201 Created



**Add a new entry to WeddingVendor :**  
This request allows for the addition of new Vendors

Path:  
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;/mydiary/wedding/new_vendor

Example:

```
POST
{
    "vendorname": "IHOP",
    "vendortype": "Caterer",
    "budget": 3500,
    "eventhandled":1
}

```  

Response:  
HTTP/1.1 201 Created


 <br/><br/>
**Get details of all Events :**  
This request retrieves all the details of the various events for the Wedding

Path:  
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;/mydiary/wedding/events


 <br/><br/>
**Get details of all Clothing :**  
This request retrieves all the clothing details of the bridal party for the Wedding


Path:  
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;/mydiary/wedding/clothing


 <br/><br/>
**Get details of all Vendors :**  
This request retrieves all the details of the different vendors for the Wedding


Path:
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;/mydiary/wedding/vendors


 <br/><br/>
**Get event details based on type of event :**  
This request retrieves all the details of the events related to Wedding and vendors


Path:
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;/mydiary/wedding/event/{event}


Parameters:  
{event} - Event name you wish to retrieve information about


 <br/><br/>
**Update dress trial date :**  
This request updates the trial date for any of the Wedding Clothing
   
Path:
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;/mydiary/wedding/trialdate/{trialdate}/{newdate}/{dress}  

Parameters:  
{trialdate} - Current trial date  
{newdate} - new trial date  
{dress} - Dress for which date needs to be updated  


 <br/><br/>
**Update budget for particular event :**  
This request will update the budget for a particular event. It will also throw an exception if the max  budget is exceeded

Path:  
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;/mydiary/wedding/eventbudget/{budget}/{eventtype}  

Parameters:  
{budget}: Amount to be updated  
{event type} : Event for which budget needs to be updated  


 <br/><br/>
**Update vendor for a particular event :**  
This request updates the vendor for a given event


Path:
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;/mydiary/wedding/eventhandled/{vendorname}/{event}/{vendortype}  

Parameters:  
{vendorname}: Vendor to be changed  
{event} :  Event for which vendor needs to be changes  
{vendortype}: The type of vendor for which vendor needs to be changed  


 <br/><br/>
**Delete a vendor :**  
The request can be used to delete a vendor


Path:  
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;/mydiary/wedding/vendorname/{name}  

Parameters:  
{name}: Name of the vendor to be deleted  


 <br/><br/>
> **Baby Journal end points**  

- Get all baby information
- Get all on baby growth
- Get all information based on a particular year
- Get all based on name
- Post a new growth chart
- Post new Babyinfo


 <br/><br/>
**Get all baby information :**  
This requests retrieves all information from the Baby journal

Path:
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;/mydiary/baby/  


 <br/><br/>
**Get all on baby growth :**  
This information retrieves all information from the BabyGrowthChart 


Path:
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;/mydiary/baby/babygrowth 


 <br/><br/>
**Get all information based on a particular year :**  
This request retrieves all information for every baby for a given year


Path:  
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;/mydiary/baby/year/{year}  

Parameters:
{year}: Year from which to retrieve information  

 <br/><br/>
**Get all based on name :**  
This request retrieves all information based on baby name  


Path:
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;/mydiary/baby/name/{name}  


Parameters:  
{name}: Name of the baby for which to get information  

 <br/><br/>

**Post a new growth chart :**  
This request adds a new entry to the BabyGrowthChart  


Path:  
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;/mydiary/baby/addgrowth 
 
 <br/><br/>
 


**Post new Babyinfo :**  
This request adds a new entry to the baby journal


Path:  
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;/mydiary/baby/addbaby  

Example:  
```
{
    "name": "John",
    "eventday": "2015-08-22",
    "description": "First haircut"
}
```


Response:  
HTTP/1.1 201 Created	
