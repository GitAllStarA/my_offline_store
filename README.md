## My Offline Store APIs

This API provides endpoints for managing stores, products, peripherals, and sales.

### Endpoints

#### Stores
* **Get All Stores**
  * URL: GET /api/stores
  * Description: Retrieve all stores.
* **Get a Specific Store**
  * URL: GET /api/stores/{storeId}
  * Description: Retrieve details of a specific store by storeId.
* **Create a Store**
  * URL: POST /api/stores
  * Description: Create a new store.
  * Request Body Example:
    ```json
    {
      "storeName": "New Store"
    }
    ```
  * Response:
    ```json
    {
      "storeId": 1,
      "storeName": "New Store"
    }
    ```
* **Update a Store**
  * URL: PUT /api/stores/{storeId}
  * Description: Update details of a specific store by storeId.
  * Request Body Example:
    ```json
    {
      "storeName": "Updated Store Name"
    }
    ```
  * Response:
    ```json
    {
      "storeId": 1,
      "storeName": "Updated Store Name"
    }
    ```
* **Delete a Store**
  * URL: DELETE /api/stores/{storeId}
  * Description: Delete a specific store by storeId.
  * Response:
    ```json
    {
      "message": "Store deleted successfully"
    }
    ```

#### Products
* **Get All Products**
  * URL: GET /api/products
  * Description: Retrieve all products.
* **Get a Specific Product**
  * URL: GET /api/products/{productId}
  * Description: Retrieve details of a specific product by productId.
* **Create a Product**
  * URL: POST /api/products
  * Description: Create a new product.
  * Request Body Example:
    ```json
    {
      "productName": "New Product",
      "manufacturer": "Manufacturer"
    }
    ```
  * Response:
    ```json
    {
      "productId": 1,
      "productName": "New Product",
      "manufacturer": "Manufacturer"
    }
    ```
* **Update a Product**
  * URL: PUT /api/products/{productId}
  * Description: Update details of a specific product by productId.
  * Request Body Example:
    ```json
    {
      "productName": "Updated Product Name",
      "manufacturer": "Updated Manufacturer"
    }
    ```
  * Response:
    ```json
    {
      "productId": 1,
      "productName": "Updated Product Name",
      "manufacturer": "Updated Manufacturer"
    }
    ```
* **Delete a Product**
  * URL: DELETE /api/products/{productId}
  * Description: Delete a specific product by productId.
  * Response:
    ```json
    {
      "message": "Product deleted successfully"
    }
    ```

#### Peripherals
* **Get All Peripherals**
  * URL: GET /api/peripherals
  * Description: Retrieve all peripherals.
* **Get a Specific Peripheral**
  * URL: GET /api/peripherals/{peripheralId}
  * Description: Retrieve details of a specific peripheral by peripheralId.
* **Create a Peripheral**
  * URL: POST /api/peripherals
  * Description: Create a new peripheral.
  * Request Body Example:
    ```json
    {
      "peripheralName": "New Peripheral",
      "manufacturer": "Manufacturer",
      "version": "Version",
      "store": {
        "storeId": 1
      }
    }
    ```
  * Response:
    ```json
    {
      "peripheralId": 1,
      "peripheralName": "New Peripheral",
      "manufacturer": "Manufacturer",
      "version": "Version",
      "store": {
        "storeId": 1,
        "storeName": "Store Name"
      }
    }
    ```
* **Update a Peripheral**
  * URL: PUT /api/peripherals/{peripheralId}
  * Description: Update details of a specific peripheral by peripheralId.
  * Request Body Example:
    ```json
    {
      "peripheralName": "Updated Peripheral Name",
      "manufacturer": "Updated Manufacturer",
      "version": "Updated Version"
    }
    ```
  * Response:
    ```json
    {
      "peripheralId": 1,
      "peripheralName": "Updated Peripheral Name",
      "manufacturer": "Updated Manufacturer",
      "version": "Updated Version",
      "store": {
        "storeId": 1,
        "storeName": "Store Name"
      }
    }
    ```
* **Delete a Peripheral**
  * URL: DELETE /api/peripherals/{peripheralId}
  * Description: Delete a specific peripheral by peripheralId.
  * Response:
    ```json
    {
      "message": "Peripheral deleted successfully"
    }
    ```

#### StorePeripherals
* **Retrieve Peripherals for a Store**
  * URL: GET /api/store-peripherals/{storeId}
  * Description: Retrieve peripherals for a specific store by storeId.
  * Response:
    ```json
    {
      "storeId": 1,
      "storeName": "Store Name",
      "peripherals": [
        {
          "peripheralId": 1,
          "peripheralName": "Peripheral Name",
          "manufacturer": "Manufacturer",
          "version": "Version"
        }
      ]
    }
    ```

#### Sales
* **Get All Sales**
  * URL: GET /api/sales
  * Description: Retrieve all sales records.
* **Get Sales by Store**
  * URL: GET /api/sales/store/{storeId}
  * Description: Retrieve sales records for a specific store by storeId.
* **Get Sales by Product**
  * URL: GET /api/sales/product/{productId}
  * Description: Retrieve sales records for a specific product by productId.
* **Create a Sale**
  * URL: POST /api/sales
  * Description: Create a new sale record.
  * Request Body Example:
    ```json
    {
      "store": {
        "storeId": 1
      },
      "product": {
        "productId": 1
      },
      "saleDate": "2024-07-27",
      "quantitySold": 10
    }
    ```
  * Response:
    ```json
    {
      "saleId": 1,
      "store": {
        "storeId": 1,
        "storeName": "Store Name"
      },
      "product": {
        "productId": 1,
        "productName": "Product Name"
      },
      "saleDate": "2024-07-27",
      "quantitySold": 10
    }
    ```
* **Update a Sale**
  * URL: PUT /api/sales/{saleId}
  * Description: Update details of a specific sale by saleId.
  * Request Body Example:
    ```json
    {
      "store": {
        "storeId": 1
      },
      "product": {
        "productId": 1
      },
      "saleDate": "2024-07-28",
      "quantitySold": 15
    }
    ```
  * Response:
    ```json
    {
      "saleId": 1,
      "store": {
        "storeId": 1,
        "storeName": "Store Name"
      },
      "product": {
        "productId": 1,
        "productName": "Product Name"
      },
      "saleDate": "2024-07-28",
      "quantitySold": 15
    }
    ```
* **Delete a Sale**
  * URL: DELETE /api/sales/{saleId}
  * Description: Delete a specific sale by saleId.
  * Response:
    ```json
    {
      "message": "Sale deleted successfully"
    }
    ```

**This is a basic structure. You can enhance it by adding sections for:**
* Request and Response Formats
* Error Handling
* Authentication (if applicable)
* Rate Limiting
* Usage Examples
* Additional Information

**Remember to replace placeholder text with actual details and consider using code blocks for better readability.**
