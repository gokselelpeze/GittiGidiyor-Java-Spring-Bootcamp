import fetch from 'unfetch';

const checkStatus = response => {
    if (response.ok) {
        return response;
    }
    // convert non-2xx HTTP responses into errors:
    const error = new Error(response.statusText);
    error.response = response;
    return Promise.reject(error);
}

const checkInquiry = response => {
    if (response.ok) {
        alert("User with identity number: " + res.userIdentityNumber +"'s credit application confirmed. Credit limit: " + res.creditLimit);

        return response;
    }
    // convert non-2xx HTTP responses into errors:
    const error = new Error(response.statusText);
    error.response = response;
    return Promise.reject(error);
}

export const applyCredit = user =>
    fetch("api/v1/credit", {
            headers: {
                'Content-Type': 'application/json'
            },
            method: 'POST',
            body: JSON.stringify(user)
        }
    ).then(checkStatus)

export const addNewUser = user =>
    fetch("api/v1/user", {
            headers: {
                'Content-Type': 'application/json'
            },
            method: 'POST',
            body: JSON.stringify(user)
        }
    ).then(checkStatus)

export const deleteUser = userId =>
    fetch(`api/v1/user/${userId}`, {
        method: 'DELETE'
    }).then(checkStatus);


export const inquiryCredit = id =>
    fetch(`api/v1/credit/${id.identityNumber}`, {
    method: 'GET'
}).then(checkInquiry);