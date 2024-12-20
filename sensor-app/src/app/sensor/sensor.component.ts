import { Component } from '@angular/core';
import { SensorService } from '../services/sensor.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-sensor',
    styleUrls: ['./sensor.component.css'],
  standalone: true,
   imports: [CommonModule, FormsModule],
  template: `
    <div>
      <h2>Set Temperature</h2>
      <input type="number" [(ngModel)]="temperature" placeholder="Enter temperature" />
      <button (click)="setTemperature()">Set Temperature</button>

      <h2>Update Limits</h2>
      <div>
        <label>Cold Limit:</label>
        <input type="number" [(ngModel)]="limits.cold" />
      </div>
      <div>
        <label>Warm Limit:</label>
        <input type="number" [(ngModel)]="limits.warm" />
      </div>
      <div>
        <label>Hot Limit:</label>
        <input type="number" [(ngModel)]="limits.hot" />
      </div>
      <button (click)="updateLimits()">Update Limits</button>

      <h2>Temperature History</h2>
      <button (click)="getHistory()">Load History</button>
      <ul>
        <li *ngFor="let record of temperatureHistory">
          Temperature: {{ record.temperature }} °C - State: {{ record.state }} - Timestamp: {{ record.timestamp }}
        </li>
      </ul>
    </div>
  `,
  styles: []
})
export class SensorComponent {
  temperature = 0;
  limits = { cold: 22, warm: 40, hot: 50 };
  temperatureHistory: any[] = [];
  constructor(private sensorService: SensorService) {}

  getHistory() {
    this.sensorService.getTemperatureHistory().subscribe((data) => {
      this.temperatureHistory = data;
    });
  }

  updateLimits() {
    this.sensorService.updateTemperatureLimits(this.limits).subscribe(() => {
      alert('Limits updated!');
    });
  }

  setTemperature() {
    this.sensorService.setTemperature(this.temperature).subscribe((data) => {
      alert('Temperature updated! It s '+data);
    });
  }
}
