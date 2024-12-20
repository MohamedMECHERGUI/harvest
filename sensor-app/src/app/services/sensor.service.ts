import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SensorService {
  private apiUrl = 'http://http://13.61.149.185:8080/api/sensor';

  constructor(private http: HttpClient) {}

  getTemperatureHistory(): Observable<any> {
    return this.http.get(`${this.apiUrl}/history`);
  }

  updateTemperatureLimits(limits: { cold: number; warm: number; hot: number }): Observable<any> {
    return this.http.post(`${this.apiUrl}/thresholds`, limits);
  }

  setTemperature(temperature: number): Observable<any> {
    return this.http.post(`${this.apiUrl}/temperature`,  {temperature});
  }
}
