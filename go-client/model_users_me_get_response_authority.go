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

// checks if the UsersMeGetResponseAuthority type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &UsersMeGetResponseAuthority{}

// UsersMeGetResponseAuthority struct for UsersMeGetResponseAuthority
type UsersMeGetResponseAuthority struct {
	ComproCategory bool `json:"comproCategory"`
}

// NewUsersMeGetResponseAuthority instantiates a new UsersMeGetResponseAuthority object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewUsersMeGetResponseAuthority(comproCategory bool) *UsersMeGetResponseAuthority {
	this := UsersMeGetResponseAuthority{}
	this.ComproCategory = comproCategory
	return &this
}

// NewUsersMeGetResponseAuthorityWithDefaults instantiates a new UsersMeGetResponseAuthority object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewUsersMeGetResponseAuthorityWithDefaults() *UsersMeGetResponseAuthority {
	this := UsersMeGetResponseAuthority{}
	return &this
}

// GetComproCategory returns the ComproCategory field value
func (o *UsersMeGetResponseAuthority) GetComproCategory() bool {
	if o == nil {
		var ret bool
		return ret
	}

	return o.ComproCategory
}

// GetComproCategoryOk returns a tuple with the ComproCategory field value
// and a boolean to check if the value has been set.
func (o *UsersMeGetResponseAuthority) GetComproCategoryOk() (*bool, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ComproCategory, true
}

// SetComproCategory sets field value
func (o *UsersMeGetResponseAuthority) SetComproCategory(v bool) {
	o.ComproCategory = v
}

func (o UsersMeGetResponseAuthority) MarshalJSON() ([]byte, error) {
	toSerialize,err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o UsersMeGetResponseAuthority) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["comproCategory"] = o.ComproCategory
	return toSerialize, nil
}

type NullableUsersMeGetResponseAuthority struct {
	value *UsersMeGetResponseAuthority
	isSet bool
}

func (v NullableUsersMeGetResponseAuthority) Get() *UsersMeGetResponseAuthority {
	return v.value
}

func (v *NullableUsersMeGetResponseAuthority) Set(val *UsersMeGetResponseAuthority) {
	v.value = val
	v.isSet = true
}

func (v NullableUsersMeGetResponseAuthority) IsSet() bool {
	return v.isSet
}

func (v *NullableUsersMeGetResponseAuthority) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableUsersMeGetResponseAuthority(val *UsersMeGetResponseAuthority) *NullableUsersMeGetResponseAuthority {
	return &NullableUsersMeGetResponseAuthority{value: val, isSet: true}
}

func (v NullableUsersMeGetResponseAuthority) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableUsersMeGetResponseAuthority) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}


