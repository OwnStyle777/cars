# CarModelApi

All URIs are relative to *http://localhost:8080*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**createCarModel**](#createcarmodel) | **POST** /api/carModel | |
|[**deleteCarModel**](#deletecarmodel) | **DELETE** /api/carModel/{id} | |
|[**getAllCarModels**](#getallcarmodels) | **GET** /api/carModel | |
|[**getCarModelById**](#getcarmodelbyid) | **GET** /api/carModel/{id} | |
|[**updateCarModel**](#updatecarmodel) | **PUT** /api/carModel/{id} | |

# **createCarModel**
> CarModelDto createCarModel(carModelDto)


### Example

```typescript
import {
    CarModelApi,
    Configuration,
    CarModelDto
} from './api';

const configuration = new Configuration();
const apiInstance = new CarModelApi(configuration);

let carModelDto: CarModelDto; //

const { status, data } = await apiInstance.createCarModel(
    carModelDto
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **carModelDto** | **CarModelDto**|  | |


### Return type

**CarModelDto**

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

# **deleteCarModel**
> CarModelDto deleteCarModel()


### Example

```typescript
import {
    CarModelApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new CarModelApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.deleteCarModel(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**number**] |  | defaults to undefined|


### Return type

**CarModelDto**

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

# **getAllCarModels**
> Array<CarModelDto> getAllCarModels()


### Example

```typescript
import {
    CarModelApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new CarModelApi(configuration);

let sortBy: string; // (optional) (default to undefined)
let direction: string; // (optional) (default to 'asc')

const { status, data } = await apiInstance.getAllCarModels(
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

**Array<CarModelDto>**

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

# **getCarModelById**
> CarModelDto getCarModelById()


### Example

```typescript
import {
    CarModelApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new CarModelApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.getCarModelById(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**number**] |  | defaults to undefined|


### Return type

**CarModelDto**

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

# **updateCarModel**
> CarModelDto updateCarModel(carModelDto)


### Example

```typescript
import {
    CarModelApi,
    Configuration,
    CarModelDto
} from './api';

const configuration = new Configuration();
const apiInstance = new CarModelApi(configuration);

let id: number; // (default to undefined)
let carModelDto: CarModelDto; //

const { status, data } = await apiInstance.updateCarModel(
    id,
    carModelDto
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **carModelDto** | **CarModelDto**|  | |
| **id** | [**number**] |  | defaults to undefined|


### Return type

**CarModelDto**

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

