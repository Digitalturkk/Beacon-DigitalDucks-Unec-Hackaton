import ProgressChart from '../../Components/Charts/ProgressChart';
import RadialGauge from '../../Components/Charts/RadialGauge';
import './home.css';

const progressData = [
  { name: 'Mon', value: 22 },
  { name: 'Tue', value: 38 },
  { name: 'Wed', value: 31 },
  { name: 'Thu', value: 45 },
  { name: 'Fri', value: 50 },
  { name: 'Sat', value: 60 },
  { name: 'Sun', value: 55 }
];

const radialData = [
  { name: 'Completed', value: 72, fill: 'url(#radialGradient)' },
  { name: 'Track', value: 100, fill: '#e8eef9' }
];

const orders = [
  { id: 'PR102', date: 'Dec 12, 9:32 AM', status: 'Completed', total: '$10,234' },
  { id: 'WS20', date: 'Dec 12, 9:02 AM', status: 'In Progress', total: '$3,528' },
  { id: 'HD15', date: 'Dec 11, 10:14 PM', status: 'Pending', total: '$1,274' },
  { id: 'RG20', date: 'Dec 11, 7:32 PM', status: 'In Progress', total: '$2,982' },
  { id: 'HD20', date: 'Dec 10, 2:14 PM', status: 'Pending', total: '$2,108' },
  { id: 'PR120', date: 'Dec 09, 8:12 AM', status: 'Completed', total: '$6,320' }
];

const statusTone = {
  Completed: 'status-green',
  'In Progress': 'status-blue',
  Pending: 'status-amber'
};

export default function Home() {
  return (
    <div className="home-page">
      <header className="home-header">
        <div>
          <p className="eyebrow">Dashboard</p>
          <h1>Your Progress</h1>
        </div>
        <div className="profile-chip">
          <div className="chip-avatar">AJ</div>
          <div className="chip-meta">
            <span className="chip-name">Alex Johnson</span>
            <span className="chip-role">Department: Sales · Level Junior</span>
          </div>
          <button className="chip-button" type="button">
            Edit profile
          </button>
        </div>
      </header>

      <div className="home-grid">
        <div className="card chart-card">
          <div className="card-header">
            <h2>Your Progress</h2>
          </div>
          <div className="chart-wrap">
            <ProgressChart data={progressData} />
          </div>
        </div>

        <div className="card gauge-card">
          <div className="card-header">
            <h2>Continue learning</h2>
          </div>
          <RadialGauge data={radialData} value="23,648" subtitle="Users by device" />
        </div>
      </div>

      <div className="card table-card">
        <div className="table-head">
          <div>
            <p className="eyebrow">Recent orders</p>
            <h3>Completed tasks</h3>
          </div>
          <span className="table-meta">Last 7 days</span>
        </div>
        <div className="table">
          <div className="table-row table-row--head">
            <span>Order</span>
            <span>Date</span>
            <span>Status</span>
            <span>Total</span>
          </div>
          {orders.map((order) => (
            <div key={order.id} className="table-row">
              <span className="order-id">{order.id}</span>
              <span className="order-date">{order.date}</span>
              <span className={`order-status ${statusTone[order.status]}`}>{order.status}</span>
              <span className="order-total">{order.total}</span>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}