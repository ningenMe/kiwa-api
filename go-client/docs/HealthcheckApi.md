# \HealthcheckApi

All URIs are relative to *https://kiwa-api.ningenme.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**HealthcheckGet**](HealthcheckApi.md#HealthcheckGet) | **Get** /healthcheck | 



## HealthcheckGet

> HealthcheckGetResponse HealthcheckGet(ctx).Execute()



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "github.com/GIT_USER_ID/GIT_REPO_ID"
)

func main() {

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.HealthcheckApi.HealthcheckGet(context.Background()).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `HealthcheckApi.HealthcheckGet``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `HealthcheckGet`: HealthcheckGetResponse
    fmt.Fprintf(os.Stdout, "Response from `HealthcheckApi.HealthcheckGet`: %v\n", resp)
}
```

### Path Parameters

This endpoint does not need any parameter.

### Other Parameters

Other parameters are passed through a pointer to a apiHealthcheckGetRequest struct via the builder pattern


### Return type

[**HealthcheckGetResponse**](HealthcheckGetResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

