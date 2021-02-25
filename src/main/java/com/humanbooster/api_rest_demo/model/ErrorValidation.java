/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humanbooster.api_rest_demo.model;

/**
 *
 * @author HB
 */
public class ErrorValidation {

    private String input;
    private String error;

    public ErrorValidation() {
        
    }
    
    public ErrorValidation(String input, String error) {
        this.input = input;
        this.error = error;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ErrorValidation{" + "input=" + input + ", error=" + error + '}';
    }

}
