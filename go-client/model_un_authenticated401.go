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

// checks if the UnAuthenticated401 type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &UnAuthenticated401{}

// UnAuthenticated401 struct for UnAuthenticated401
type UnAuthenticated401 struct {
	Message string `json:"message"`
}

// NewUnAuthenticated401 instantiates a new UnAuthenticated401 object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewUnAuthenticated401(message string) *UnAuthenticated401 {
	this := UnAuthenticated401{}
	this.Message = message
	return &this
}

// NewUnAuthenticated401WithDefaults instantiates a new UnAuthenticated401 object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewUnAuthenticated401WithDefaults() *UnAuthenticated401 {
	this := UnAuthenticated401{}
	return &this
}

// GetMessage returns the Message field value
func (o *UnAuthenticated401) GetMessage() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Message
}

// GetMessageOk returns a tuple with the Message field value
// and a boolean to check if the value has been set.
func (o *UnAuthenticated401) GetMessageOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Message, true
}

// SetMessage sets field value
func (o *UnAuthenticated401) SetMessage(v string) {
	o.Message = v
}

func (o UnAuthenticated401) MarshalJSON() ([]byte, error) {
	toSerialize,err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o UnAuthenticated401) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["message"] = o.Message
	return toSerialize, nil
}

type NullableUnAuthenticated401 struct {
	value *UnAuthenticated401
	isSet bool
}

func (v NullableUnAuthenticated401) Get() *UnAuthenticated401 {
	return v.value
}

func (v *NullableUnAuthenticated401) Set(val *UnAuthenticated401) {
	v.value = val
	v.isSet = true
}

func (v NullableUnAuthenticated401) IsSet() bool {
	return v.isSet
}

func (v *NullableUnAuthenticated401) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableUnAuthenticated401(val *UnAuthenticated401) *NullableUnAuthenticated401 {
	return &NullableUnAuthenticated401{value: val, isSet: true}
}

func (v NullableUnAuthenticated401) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableUnAuthenticated401) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}

