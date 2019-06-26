# Stocks (BCS test assignment)

####REST API for the current stock portfolio value calculation and it's sectoral distribution
This app use the API https://iextrading.com/developer/docs/#iex-market-data
App caching info about stocks and hands out to users.
Also there will be able to receive a result of calculation in real time. 


* Building:
in the root folder: mvn clean install

* Deploy (WildFly)
stocks-common-0.0.1-SNAPSHOT.war in path: "stocks-common/target/"

* How to use:

 There is just one command to REST Api:
  
 POST(header Accept=application/json):
 URL/stocks-common-0.0.1-SNAPSHOT/api/stocks/calculateBySector

For example
Body:
{
    "stocks":[
      {
         "symbol":"AAPL",
         "volume":50
      },
      {
         "symbol":"HOG",
         "volume":10
      },
      {
         "symbol":"MDSO",
         "volume":1
      },
      {
         "symbol":"IDRA",
         "volume":1
      },
      {
         "symbol":"MRSN",
         "volume":1
      }
    ]
}

ApiResult:
{
    "result": {
        "value": 10443.965,
        "allocations": [
            {
                "sector": "automobilescomponents",
                "assetValue": 357,
                "proportion": 0.034
            },
            {
                "sector": "technologyhardwareequipment",
                "assetValue": 9990,
                "proportion": 0.956
            },
            {
                "sector": "pharmaceuticalsbiotechnology",
                "assetValue": 6.61,
                "proportion": 0
            },
            {
                "sector": "healthcareequipmentservices",
                "assetValue": 90.355,
                "proportion": 0.008
            }
        ]
    },
    "status": "SUCCESS",
    "errors": null
}