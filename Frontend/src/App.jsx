import React from 'react';
import { Route, Routes } from 'react-router-dom';
import { Toaster } from 'react-hot-toast';
import Page1 from './Pages/Page1/Page1';
import SignIn from './Pages/SignIn/SignIn';
import Home from './Pages/Home/Home';
import Department from './Pages/Department/Department';
import Profile from './Pages/Profile/Profile';
import DashboardLayout from './Components/Layout/DashboardLayout';

const navItems = [
  { id: 'home', label: 'Home', path: '/home', end: true },
  { id: 'department', label: 'Department Training', path: '/department-training' },
  { id: 'practical', label: 'Practical Experience', path: '/practical-experience' },
  { id: 'support', label: 'Support & Communication', path: '/support' },
  { id: 'notifications', label: 'Notifications', path: '/notifications' },
  { id: 'profile', label: 'Profile', path: '/profile' }
];

const Placeholder = ({ title, description }) => (
  <div className="page-placeholder">
    <h1>{title}</h1>
    {description && <p>{description}</p>}
  </div>
);

function App() {
  return (
    <>
      <Toaster
        containerStyle={{
          fontFamily: 'Poppins'
        }}
        position="top-center"
        reverseOrder={false}
      />
      <Routes>
        <Route path="/" element={<Page1 />} />
        <Route path="/sign-in" element={<SignIn />} />

        <Route element={<DashboardLayout navItems={navItems} />}>
          <Route path="/home" element={<Home />} />
          <Route
            path="/department-training"
            element={<Department />}
          />
          <Route
            path="/practical-experience"
            element={<Placeholder title="Practical Experience" description="Раздел откроется позже." />}
          />
          <Route
            path="/support"
            element={<Placeholder title="Support & Communication" description="Раздел откроется позже." />}
          />
          <Route
            path="/notifications"
            element={<Placeholder title="Notifications" description="Раздел откроется позже." />}
          />
          <Route
            path="/profile"
            element={<Profile />}
          />
        </Route>
      </Routes>
    </>
  );
}

export default App;