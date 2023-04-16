# UsersMeGetResponse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**UserId** | **string** |  | 
**Authority** | [**UsersMeGetResponseAuthority**](UsersMeGetResponseAuthority.md) |  | 

## Methods

### NewUsersMeGetResponse

`func NewUsersMeGetResponse(userId string, authority UsersMeGetResponseAuthority, ) *UsersMeGetResponse`

NewUsersMeGetResponse instantiates a new UsersMeGetResponse object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewUsersMeGetResponseWithDefaults

`func NewUsersMeGetResponseWithDefaults() *UsersMeGetResponse`

NewUsersMeGetResponseWithDefaults instantiates a new UsersMeGetResponse object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetUserId

`func (o *UsersMeGetResponse) GetUserId() string`

GetUserId returns the UserId field if non-nil, zero value otherwise.

### GetUserIdOk

`func (o *UsersMeGetResponse) GetUserIdOk() (*string, bool)`

GetUserIdOk returns a tuple with the UserId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUserId

`func (o *UsersMeGetResponse) SetUserId(v string)`

SetUserId sets UserId field to given value.


### GetAuthority

`func (o *UsersMeGetResponse) GetAuthority() UsersMeGetResponseAuthority`

GetAuthority returns the Authority field if non-nil, zero value otherwise.

### GetAuthorityOk

`func (o *UsersMeGetResponse) GetAuthorityOk() (*UsersMeGetResponseAuthority, bool)`

GetAuthorityOk returns a tuple with the Authority field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAuthority

`func (o *UsersMeGetResponse) SetAuthority(v UsersMeGetResponseAuthority)`

SetAuthority sets Authority field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


