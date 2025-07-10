# CarTypeApi

All URIs are relative to *http://localhost:8080*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**createCarType**](#createcartype) | **POST** /api/carType | |
|[**deleteCarType**](#deletecartype) | **DELETE** /api/carType/{id} | |
|[**getAllCarTypes**](#getallcartypes) | **GET** /api/carType | |
|[**getCarTypeById**](#getcartypebyid) | **GET** /api/carType/{id} | |
|[**updateCarType**](#updatecartype) | **PUT** /api/carType/{id} | |

# **createCarType**
> CarTypeDto createCarType(carTypeDto)


### Example

```typescript
import {
    CarTypeApi,
    Configuration,
    CarTypeDto
} from './api';

const configuration = new Configuration();
const apiInstance = new CarTypeApi(configuration);

let carTypeDto: CarTypeDto; //

const { status, data } = await apiInstance.createCarType(
    carTypeDto
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **carTypeDto** | **CarTypeDto**|  | |


### Return type

**CarTypeDto**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteCarType**
> CarTypeDto deleteCarType()


### Example

```typescript
import {
    CarTypeApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new CarTypeApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.deleteCarType(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**number**] |  | defaults to undefined|


### Return type

**CarTypeDto**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getAllCarTypes**
> Array<CarTypeDto> getAllCarTypes()


### Example

```typescript
import {
    CarTypeApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new CarTypeApi(configuration);

let sortBy: string; // (optional) (default to undefined)
let direction: string; // (optional) (default to 'asc')

const { status, data } = await apiInstance.getAllCarTypes(
    sortBy,
    direction
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **sortBy** | [**string**] |  | (optional) defaults to undefined|
| **direction** | [**string**] |  | (optional) defaults to 'asc'|


### Return type

**Array<CarTypeDto>**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCarTypeById**
> CarTypeDto getCarTypeById()


### Example

```typescript
import {
    CarTypeApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new CarTypeApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.getCarTypeById(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**number**] |  | defaults to undefined|


### Return type

**CarTypeDto**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateCarType**
> CarTypeDto updateCarType(carTypeDto)


### Example

```typescript
import {
    CarTypeApi,
    Configuration,
    CarTypeDto
} from './api';

const configuration = new Configuration();
const apiInstance = new CarTypeApi(configuration);

let id: number; // (default to undefined)
let carTypeDto: CarTypeDto; //

const { status, data } = await apiInstance.updateCarType(
    id,
    carTypeDto
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **carTypeDto** | **CarTypeDto**|  | |
| **id** | [**number**] |  | defaults to undefined|


### Return type

**CarTypeDto**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

