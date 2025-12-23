import './profile.css';

const personalFields = [
  { id: 'fullName', label: 'Full name', value: 'John Carter', placeholder: 'Enter your full name' },
  { id: 'email', label: 'Email address', value: 'john@digitalducks.com', placeholder: 'Enter your email' },
  { id: 'phone', label: 'Phone', value: '+1 (555) 123-9876', placeholder: 'Enter your phone' },
  { id: 'about', label: 'Short description', value: '', placeholder: 'Write a short bio...' }
];

const basicFields = [
  { id: 'age', label: 'Age', value: '19', placeholder: 'Enter your age' },
  { id: 'position', label: 'Position', value: 'CSO & Founder', placeholder: 'Enter your position' },
  { id: 'location', label: 'Location', value: 'New York, NY', placeholder: 'Enter your city' },
  { id: 'website', label: 'Website', value: 'dribbble.com', placeholder: 'Enter your website' }
];

export default function Profile() {
  return (
    <div className="profile-page">
      <aside className="profile-side">
        <h2>Credentials</h2>
        <div className="profile-tabs">
          <button type="button" className="tab active">
            Personal information
          </button>
          <button type="button" className="tab">
            Team
          </button>
        </div>
      </aside>

      <section className="profile-content">
        <div className="section-card">
          <header className="section-head">
            <div>
              <p className="eyebrow">Personal Information</p>
              <p className="muted">Update your basic info so we can personalize collaboration.</p>
            </div>
            <button type="button" className="link-button">
              Save changes
            </button>
          </header>

          <div className="grid two-col">
            {personalFields.slice(0, 3).map((field) => (
              <div key={field.id} className="field">
                <label htmlFor={field.id}>{field.label}</label>
                <input id={field.id} defaultValue={field.value} placeholder={field.placeholder} />
              </div>
            ))}
          </div>

          <div className="avatar-row">
            <div className="avatar-circle large">JC</div>
            <div className="avatar-actions">
              <button type="button" className="btn-secondary">
                Upload photo
              </button>
              <button type="button" className="link-button">Remove</button>
              <p className="muted">PNG or JPG no larger than 5MB</p>
            </div>
          </div>

          <div className="field">
            <label htmlFor="about">{personalFields[3].label}</label>
            <textarea id="about" rows="3" placeholder={personalFields[3].placeholder} defaultValue={personalFields[3].value} />
          </div>
        </div>

        <div className="section-card">
          <header className="section-head">
            <div>
              <p className="eyebrow">Basic information</p>
              <p className="muted">Share more to boost team collaboration.</p>
            </div>
          </header>

          <div className="grid two-col">
            {basicFields.map((field) => (
              <div key={field.id} className="field">
                <label htmlFor={field.id}>{field.label}</label>
                <input id={field.id} defaultValue={field.value} placeholder={field.placeholder} />
              </div>
            ))}
          </div>
        </div>
      </section>
    </div>
  );
}

