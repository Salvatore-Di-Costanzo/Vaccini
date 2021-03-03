const NOMIREGIONI_REST_API = 'http://localhost:8080/nomiRegioni';
const TOTALE_CONTAGI_API = 'http://localhost:8080/nuoviPositivi';
class APIService {
    getNomiRegioni(){
        return fetch(NOMIREGIONI_REST_API,{
            method: 'get',
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json',
            },
            'credentials': 'same-origin'
        })
            .then(res => res.json());
    }
    getTotaleContagi(){
        return fetch(TOTALE_CONTAGI_API,{
            method: 'get',
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json',
            },
            'credentials': 'same-origin'
        })
            .then(res => res.json());
    }

}

export default new APIService();