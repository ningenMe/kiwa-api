/* tslint:disable */
/* eslint-disable */
/**
 * kiwa-api
 * api created by ningenme
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


import type { Configuration } from './configuration';
import type { AxiosPromise, AxiosInstance, AxiosRequestConfig } from 'axios';
import globalAxios from 'axios';
// Some imports not used depending on template conditions
// @ts-ignore
import { DUMMY_BASE_URL, assertParamExists, setApiKeyToObject, setBasicAuthToObject, setBearerAuthToObject, setOAuthToObject, setSearchParams, serializeDataIfNeeded, toPathString, createRequestFunction } from './common';
import type { RequestArgs } from './base';
// @ts-ignore
import { BASE_PATH, COLLECTION_FORMATS, BaseAPI, RequiredError } from './base';

/**
 * 
 * @export
 * @interface HealthcheckGetResponse
 */
export interface HealthcheckGetResponse {
    /**
     * 
     * @type {string}
     * @memberof HealthcheckGetResponse
     */
    'message': string;
}

/**
 * HealthcheckApi - axios parameter creator
 * @export
 */
export const HealthcheckApiAxiosParamCreator = function (configuration?: Configuration) {
    return {
        /**
         * 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        healthGet: async (options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            const localVarPath = `/healthcheck`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'GET', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;


    
            setSearchParams(localVarUrlObj, localVarQueryParameter);
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};

            return {
                url: toPathString(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
    }
};

/**
 * HealthcheckApi - functional programming interface
 * @export
 */
export const HealthcheckApiFp = function(configuration?: Configuration) {
    const localVarAxiosParamCreator = HealthcheckApiAxiosParamCreator(configuration)
    return {
        /**
         * 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async healthGet(options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<HealthcheckGetResponse>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.healthGet(options);
            return createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration);
        },
    }
};

/**
 * HealthcheckApi - factory interface
 * @export
 */
export const HealthcheckApiFactory = function (configuration?: Configuration, basePath?: string, axios?: AxiosInstance) {
    const localVarFp = HealthcheckApiFp(configuration)
    return {
        /**
         * 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        healthGet(options?: any): AxiosPromise<HealthcheckGetResponse> {
            return localVarFp.healthGet(options).then((request) => request(axios, basePath));
        },
    };
};

/**
 * HealthcheckApi - object-oriented interface
 * @export
 * @class HealthcheckApi
 * @extends {BaseAPI}
 */
export class HealthcheckApi extends BaseAPI {
    /**
     * 
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof HealthcheckApi
     */
    public healthGet(options?: AxiosRequestConfig) {
        return HealthcheckApiFp(this.configuration).healthGet(options).then((request) => request(this.axios, this.basePath));
    }
}

