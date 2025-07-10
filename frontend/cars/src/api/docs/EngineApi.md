# EngineApi

All URIs are relative to *http://localhost:8080*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**createEngine**](#createengine) | **POST** /api/engine | |
|[**deleteEngine**](#deleteengine) | **DELETE** /api/engine/{id} | |
|[**getAllEngines**](#getallengines) | **GET** /api/engine | |
|[**getEngineById**](#getenginebyid) | **GET** /api/engine/{id} | |
|[**updateEngine**](#updateengine) | **PUT** /api/engine/{id} | |

# **createEngine**
> EngineDto createEngine(engineDto)


### Example

```typescript
import {
    EngineApi,
    Configuration,
    EngineDto
} from './api';

const configuration = new Configuration();
const apiInstance = new EngineApi(configuration);

let engineDto: EngineDto; //

const { status, data } = await apiInstance.createEngine(
    engineDto
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **engineDto** | **EngineDto**|  | |


### Return type

**EngineDto**

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

# **deleteEngine**
> EngineDto deleteEngine()


### Example

```typescript
import {
    EngineApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new EngineApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.deleteEngine(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**number**] |  | defaults to undefined|


### Return type

**EngineDto**

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

# **getAllEngines**
> Array<EngineDto> getAllEngines()


### Example

```typescript
import {
    EngineApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new EngineApi(configuration);

let sortBy: string; // (optional) (default to undefined)
let direction: string; // (optional) (default to 'asc')

const { status, data } = await apiInstance.getAllEngines(
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

**Array<EngineDto>**

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

# **getEngineById**
> EngineDto getEngineById()


### Example

```typescript
import {
    EngineApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new EngineApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.getEngineById(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**number**] |  | defaults to undefined|


### Return type

**EngineDto**

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

# **updateEngine**
> EngineDto updateEngine(engineDto)


### Example

```typescript
import {
    EngineApi,
    Configuration,
    EngineDto
} from './api';

const configuration = new Configuration();
const apiInstance = new EngineApi(configuration);

let id: number; // (default to undefined)
let engineDto: EngineDto; //

const { status, data } = await apiInstance.updateEngine(
    id,
    engineDto
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **engineDto** | **EngineDto**|  | |
| **id** | [**number**] |  | defaults to undefined|


### Return type

**EngineDto**

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

