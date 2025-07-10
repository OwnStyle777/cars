# CarApi

All URIs are relative to *http://localhost:8080*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**createCar**](#createcar) | **POST** /api/car | |
|[**deleteCar**](#deletecar) | **DELETE** /api/car/{id} | |
|[**getAllCars**](#getallcars) | **GET** /api/car | |
|[**getCarById**](#getcarbyid) | **GET** /api/car/{id} | |
|[**updateCar**](#updatecar) | **PUT** /api/car/{id} | |

# **createCar**
> CarDto createCar(carDto)


### Example

```typescript
import {
    CarApi,
    Configuration,
    CarDto
} from './api';

const configuration = new Configuration();
const apiInstance = new CarApi(configuration);

let carDto: CarDto; //

const { status, data } = await apiInstance.createCar(
    carDto
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **carDto** | **CarDto**|  | |


### Return type

**CarDto**

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

# **deleteCar**
> CarDto deleteCar()


### Example

```typescript
import {
    CarApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new CarApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.deleteCar(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**number**] |  | defaults to undefined|


### Return type

**CarDto**

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

# **getAllCars**
> Array<CarDto> getAllCars()


### Example

```typescript
import {
    CarApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new CarApi(configuration);

let sortBy: string; // (optional) (default to undefined)
let direction: string; // (optional) (default to 'asc')

const { status, data } = await apiInstance.getAllCars(
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

**Array<CarDto>**

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

# **getCarById**
> CarDto getCarById()


### Example

```typescript
import {
    CarApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new CarApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.getCarById(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**number**] |  | defaults to undefined|


### Return type

**CarDto**

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

# **updateCar**
> CarDto updateCar(carDto)


### Example

```typescript
import {
    CarApi,
    Configuration,
    CarDto
} from './api';

const configuration = new Configuration();
const apiInstance = new CarApi(configuration);

let id: number; // (default to undefined)
let carDto: CarDto; //

const { status, data } = await apiInstance.updateCar(
    id,
    carDto
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **carDto** | **CarDto**|  | |
| **id** | [**number**] |  | defaults to undefined|


### Return type

**CarDto**

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

