
# Java Coding Challenge

You are being asked to create a simple contact entry system. You should create a REST API that will enable a client to perform CRUD operations on the contact collection.

REQUIREMENTS

  1. Create a new REST API using Java / JVM technologies with the following endpoints:


| HTTP Method | Route | Description |
| ----------- | ----- | ----------- |
| GET | /contacts | List all contacts |
| POST | /contacts | Create a new contact |
| PUT | /contacts/{id} | Update a contact |
| GET | /contacts/{id} | Get a specific contact |
| DELETE | /contacts/{id} | Delete a contact |

  2. The contact entry request when creating or updating a contact will be JSON and the following format:


| Format | Example |
| ------ | ------- |

```json
{
    "name": {
        "first": "Harold",
        "middle": "Francis",
        "last": "Gilkey"
    },
    "address": {
        "street": "8360 High Autumn Road",
        "city": "Cannon",
        "state": "Delaware",
        "zip": "19797"
    },
    "phone": [
        {
            "number": "302-611-9148",
            "type": "mobile"
        }
    ],
    "email": "harold.gilkey@yahoo.com"
}
```
