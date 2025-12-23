import { Outlet } from 'react-router-dom';
import Sidebar from '../Sidebar/Sidebar';
import './dashboard.css';

export default function DashboardLayout({ navItems }) {
  return (
    <div className="dashboard-shell">
      <Sidebar navItems={navItems} />
      <main className="page-area">
        <Outlet />
      </main>
    </div>
  );
}

