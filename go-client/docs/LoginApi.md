# \LoginApi

All URIs are relative to *https://kiwa-api.ningenme.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**LoginPost**](LoginApi.md#LoginPost) | **Post** /login | 



## LoginPost

> LoginPostResponse LoginPost(ctx).LoginPostRequest(loginPostRequest).Execute()



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
    loginPostRequest := *openapiclient.NewLoginPostRequest("UserId_example", "Password_example") // LoginPostRequest | 

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.LoginApi.LoginPost(context.Background()).LoginPostRequest(loginPostRequest).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `LoginApi.LoginPost``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `LoginPost`: LoginPostResponse
    fmt.Fprintf(os.Stdout, "Response from `LoginApi.LoginPost`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiLoginPostRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **loginPostRequest** | [**LoginPostRequest**](LoginPostRequest.md) |  | 

### Return type

[**LoginPostResponse**](LoginPostResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

