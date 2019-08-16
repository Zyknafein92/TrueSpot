/**
 * Swagger Maven Plugin Sample
 * This is a sample.
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
import { Department } from './department';
import { User } from './user';


export interface Topo {
    id?: number;
    name?: string;
    user?: User;
    department?: Department;
    description?: string;
    nearestCity?: string;
    carAccess?: boolean;
    carParking?: boolean;
    accessDescription?: string;
    nearestHospital?: string;
    supplyComment?: string;
}
