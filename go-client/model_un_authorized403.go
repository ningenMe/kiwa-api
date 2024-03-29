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

// checks if the UnAuthorized403 type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &UnAuthorized403{}

// UnAuthorized403 struct for UnAuthorized403
type UnAuthorized403 struct {
	Message string `json:"message"`
}

// NewUnAuthorized403 instantiates a new UnAuthorized403 object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewUnAuthorized403(message string) *UnAuthorized403 {
	this := UnAuthorized403{}
	this.Message = message
	return &this
}

// NewUnAuthorized403WithDefaults instantiates a new UnAuthorized403 object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewUnAuthorized403WithDefaults() *UnAuthorized403 {
	this := UnAuthorized403{}
	return &this
}

// GetMessage returns the Message field value
func (o *UnAuthorized403) GetMessage() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Message
}

// GetMessageOk returns a tuple with the Message field value
// and a boolean to check if the value has been set.
func (o *UnAuthorized403) GetMessageOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Message, true
}

// SetMessage sets field value
func (o *UnAuthorized403) SetMessage(v string) {
	o.Message = v
}

func (o UnAuthorized403) MarshalJSON() ([]byte, error) {
	toSerialize,err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o UnAuthorized403) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["message"] = o.Message
	return toSerialize, nil
}

type NullableUnAuthorized403 struct {
	value *UnAuthorized403
	isSet bool
}

func (v NullableUnAuthorized403) Get() *UnAuthorized403 {
	return v.value
}

func (v *NullableUnAuthorized403) Set(val *UnAuthorized403) {
	v.value = val
	v.isSet = true
}

func (v NullableUnAuthorized403) IsSet() bool {
	return v.isSet
}

func (v *NullableUnAuthorized403) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableUnAuthorized403(val *UnAuthorized403) *NullableUnAuthorized403 {
	return &NullableUnAuthorized403{value: val, isSet: true}
}

func (v NullableUnAuthorized403) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableUnAuthorized403) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}


