/*
kiwa-api

api created by ningenme

API version: 1.0.0
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.

package openapi

import (
	"encoding/json"
)

// checks if the UsersPostRequest type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &UsersPostRequest{}

// UsersPostRequest struct for UsersPostRequest
type UsersPostRequest struct {
	UserId string `json:"userId"`
	Password string `json:"password"`
}

// NewUsersPostRequest instantiates a new UsersPostRequest object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewUsersPostRequest(userId string, password string) *UsersPostRequest {
	this := UsersPostRequest{}
	this.UserId = userId
	this.Password = password
	return &this
}

// NewUsersPostRequestWithDefaults instantiates a new UsersPostRequest object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewUsersPostRequestWithDefaults() *UsersPostRequest {
	this := UsersPostRequest{}
	return &this
}

// GetUserId returns the UserId field value
func (o *UsersPostRequest) GetUserId() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.UserId
}

// GetUserIdOk returns a tuple with the UserId field value
// and a boolean to check if the value has been set.
func (o *UsersPostRequest) GetUserIdOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.UserId, true
}

// SetUserId sets field value
func (o *UsersPostRequest) SetUserId(v string) {
	o.UserId = v
}

// GetPassword returns the Password field value
func (o *UsersPostRequest) GetPassword() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Password
}

// GetPasswordOk returns a tuple with the Password field value
// and a boolean to check if the value has been set.
func (o *UsersPostRequest) GetPasswordOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Password, true
}

// SetPassword sets field value
func (o *UsersPostRequest) SetPassword(v string) {
	o.Password = v
}

func (o UsersPostRequest) MarshalJSON() ([]byte, error) {
	toSerialize,err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o UsersPostRequest) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["userId"] = o.UserId
	toSerialize["password"] = o.Password
	return toSerialize, nil
}

type NullableUsersPostRequest struct {
	value *UsersPostRequest
	isSet bool
}

func (v NullableUsersPostRequest) Get() *UsersPostRequest {
	return v.value
}

func (v *NullableUsersPostRequest) Set(val *UsersPostRequest) {
	v.value = val
	v.isSet = true
}

func (v NullableUsersPostRequest) IsSet() bool {
	return v.isSet
}

func (v *NullableUsersPostRequest) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableUsersPostRequest(val *UsersPostRequest) *NullableUsersPostRequest {
	return &NullableUsersPostRequest{value: val, isSet: true}
}

func (v NullableUsersPostRequest) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableUsersPostRequest) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}


