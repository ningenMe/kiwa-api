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

// checks if the InternalServerError500 type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &InternalServerError500{}

// InternalServerError500 struct for InternalServerError500
type InternalServerError500 struct {
	Message string `json:"message"`
}

// NewInternalServerError500 instantiates a new InternalServerError500 object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewInternalServerError500(message string) *InternalServerError500 {
	this := InternalServerError500{}
	this.Message = message
	return &this
}

// NewInternalServerError500WithDefaults instantiates a new InternalServerError500 object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewInternalServerError500WithDefaults() *InternalServerError500 {
	this := InternalServerError500{}
	return &this
}

// GetMessage returns the Message field value
func (o *InternalServerError500) GetMessage() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Message
}

// GetMessageOk returns a tuple with the Message field value
// and a boolean to check if the value has been set.
func (o *InternalServerError500) GetMessageOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Message, true
}

// SetMessage sets field value
func (o *InternalServerError500) SetMessage(v string) {
	o.Message = v
}

func (o InternalServerError500) MarshalJSON() ([]byte, error) {
	toSerialize,err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o InternalServerError500) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["message"] = o.Message
	return toSerialize, nil
}

type NullableInternalServerError500 struct {
	value *InternalServerError500
	isSet bool
}

func (v NullableInternalServerError500) Get() *InternalServerError500 {
	return v.value
}

func (v *NullableInternalServerError500) Set(val *InternalServerError500) {
	v.value = val
	v.isSet = true
}

func (v NullableInternalServerError500) IsSet() bool {
	return v.isSet
}

func (v *NullableInternalServerError500) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableInternalServerError500(val *InternalServerError500) *NullableInternalServerError500 {
	return &NullableInternalServerError500{value: val, isSet: true}
}

func (v NullableInternalServerError500) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableInternalServerError500) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}


