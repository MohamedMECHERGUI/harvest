import { Component } from '@angular/core';
import { SensorComponent } from './sensor/sensor.component';
@Component({
  selector: 'app-root',
  standalone: true,
  template: `
    <div class="container">
      <h1>Sensor Management</h1>
      <app-sensor></app-sensor>
    </div>
  `,
  imports: [SensorComponent],
  styles: [`
    .container {
      font-family: Arial, sans-serif;
      margin: 20px;
    }
  `]
})
export class AppComponent {}
