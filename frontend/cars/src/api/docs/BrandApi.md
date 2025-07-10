# BrandApi

All URIs are relative to *http://localhost:8080*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**createBrand**](#createbrand) | **POST** /api/brand | |
|[**deleteBrand**](#deletebrand) | **DELETE** /api/brand/{id} | |
|[**getAllBrands**](#getallbrands) | **GET** /api/brand | |
|[**getBrandById**](#getbrandbyid) | **GET** /api/brand/{id} | |
|[**updateBrand**](#updatebrand) | **PUT** /api/brand/{id} | |

# **createBrand**
> BrandDto createBrand(brandDto)


### Example

```typescript
import {
    BrandApi,
    Configuration,
    BrandDto
} from './api';

const configuration = new Configuration();
const apiInstance = new BrandApi(configuration);

let brandDto: BrandDto; //

const { status, data } = await apiInstance.createBrand(
    brandDto
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **brandDto** | **BrandDto**|  | |


### Return type

**BrandDto**

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

# **deleteBrand**
> BrandDto deleteBrand()


### Example

```typescript
import {
    BrandApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new BrandApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.deleteBrand(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**number**] |  | defaults to undefined|


### Return type

**BrandDto**

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

# **getAllBrands**
> Array<BrandDto> getAllBrands()


### Example

```typescript
import {
    BrandApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new BrandApi(configuration);

let sortBy: string; // (optional) (default to undefined)
let direction: string; // (optional) (default to 'asc')

const { status, data } = await apiInstance.getAllBrands(
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

**Array<BrandDto>**

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

# **getBrandById**
> BrandDto getBrandById()


### Example

```typescript
import {
    BrandApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new BrandApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.getBrandById(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**number**] |  | defaults to undefined|


### Return type

**BrandDto**

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

# **updateBrand**
> BrandDto updateBrand(brandDto)


### Example

```typescript
import {
    BrandApi,
    Configuration,
    BrandDto
} from './api';

const configuration = new Configuration();
const apiInstance = new BrandApi(configuration);

let id: number; // (default to undefined)
let brandDto: BrandDto; //

const { status, data } = await apiInstance.updateBrand(
    id,
    brandDto
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **brandDto** | **BrandDto**|  | |
| **id** | [**number**] |  | defaults to undefined|


### Return type

**BrandDto**

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

