import { NavLink } from 'react-router-dom';
import logo from '../../assets/logo.png';

export default function Sidebar({ navItems = [] }) {
  return (
    <aside className="sidebar">
      <div className="brand">
        <div className="brand-logo-wrap">
          <img src={logo} alt="Beacon" className="brand-logo" />
        </div>
      </div>

      <nav className="menu">
        {navItems.map((item) => (
          <NavLink
            key={item.id}
            to={item.path}
            end={item.end}
            className={({ isActive }) => (isActive ? 'menu-link active' : 'menu-link')}
          >
            <span className="menu-indicator" />
            <span className="menu-label">{item.label}</span>
          </NavLink>
        ))}
      </nav>

      <div className="sidebar-footer">
        <div className="profile-badge">
          <div className="avatar-circle">JD</div>
          <div className="profile-meta">
            <span className="profile-name">John Doe</span>
            <span className="profile-role">Level Junior</span>
          </div>
        </div>
      </div>
    </aside>
  );
}

